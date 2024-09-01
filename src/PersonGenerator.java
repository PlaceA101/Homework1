import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;


public class PersonGenerator {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> peopleData = new ArrayList<>();


        while (true) {
            System.out.println("Enter details for a person:");
            String id = SafeInput.getNonZeroLenString(in, "ID ");
            if (id.isEmpty()) {
                System.out.println("ID cannot be empty. Please enter all details.");
                continue;
            }

            String firstName = SafeInput.getNonZeroLenString(in, "First Name ");
            if (firstName.isEmpty()) {
                System.out.println("First Name cannot be empty. Please enter all details.");
                continue;
            }

            String lastName = SafeInput.getNonZeroLenString(in, "Last Name ");
            if (lastName.isEmpty()) {
                System.out.println("Last Name cannot be empty. Please enter all details.");
                continue;
            }

            String title = SafeInput.getNonZeroLenString(in, "Title ");
            if (title.isEmpty()) {
                System.out.println("Title cannot be empty. Please enter all details.");
                continue;
            }


            String yearOfBirth = SafeInput.getNonZeroLenString(in, "Year of Birth ");
            if (yearOfBirth.isEmpty()) {
                System.out.println("Year of Birth cannot be empty. Please enter all details.");
                continue;
            }


            String personInfo = String.format("ID: %s, First Name: %s, Last Name: %s, Title: %s, Year of Birth: %s",
                    id, firstName, lastName, title, yearOfBirth);
            peopleData.add(personInfo);


            System.out.print("Do you want to enter another person? (yes/no): ");
            String response = in.nextLine();
            if (response.equalsIgnoreCase("no")) {
                break;
            }
        }


        System.out.print("Enter the name of the file to save the data (with .txt extension): ");
        String fileName = in.nextLine();


        try (FileWriter writer = new FileWriter(fileName)) {
            for (String line : peopleData) {
                writer.write(line + System.lineSeparator());
            }
            System.out.println("Data successfully saved to " + fileName);
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }


        in.close();
    }
}
