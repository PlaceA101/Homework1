import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonReader {

    public static void main(String[] args) {
        // Create a JFileChooser for selecting the file
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);

        // Check if a file was selected
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            List<String> lines = readFile(selectedFile);
            if (lines != null) {
                displayData(lines);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to read the file.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No file was selected.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Method to read the file and return lines as a List of Strings
    private static List<String> readFile(File file) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return lines;
    }

    // Method to display the data in a formatted way
    private static void displayData(List<String> lines) {
        // Create a header
        String header = String.format("%-10s %-15s %-15s %-10s %-4s", "ID", "First Name", "Last Name", "Title", "Year");
        System.out.println(header);
        System.out.println(new String(new char[header.length()]).replace('\0', '-')); // Print a separator line

        // Display each line
        for (String line : lines) {
            String[] parts = line.split(", ");
            if (parts.length == 5) {
                // Split and format the line data
                String id = parts[0].substring(4); // Remove "ID: "
                String firstName = parts[1].substring(12); // Remove "First Name: "
                String lastName = parts[2].substring(11); // Remove "Last Name: "
                String title = parts[3].substring(7); // Remove "Title: "
                String year = parts[4].substring(15); // Remove "Year of Birth: "

                // Print formatted data
                System.out.printf("%-10s %-15s %-15s %-10s %-4s%n", id, firstName, lastName, title, year);
            }
        }
    }
}
