import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;


public class ProductWriter {

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

            String firstName = SafeInput.getNonZeroLenString(in, "Name ");
            if (firstName.isEmpty()) {
                System.out.println("Name cannot be empty. Please enter all details.");
                continue;
            }

            String description = SafeInput.getNonZeroLenString(in, "Description ");
            if (description.isEmpty()) {
                System.out.println("Description cannot be empty. Please enter all details.");
                continue;
            }

            double cost = SafeInput.getDouble(in, "Cost ");




            String personInfo = String.format("ID: %s, Name: %s, Description: %s, Cost: %s,",
                    id, firstName, description, cost);
            peopleData.add(personInfo);


            System.out.print("Do you want to enter another product? (yes/no): ");
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
