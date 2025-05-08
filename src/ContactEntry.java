
import java.util.Scanner;

public class ContactEntry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Name input with exception handling example
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException("Name cannot be empty.");
            }

            // Email input - Students will add exception handling here
            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            if (email.isEmpty()) {
                throw new IllegalArgumentException("Error: Email cannot be empty.");
            }
            if (!isValidEmail(email)) {
                throw new IllegalArgumentException("Error: Invalid email format.");
            }

            // Phone number input - Students will add exception handling here
            System.out.print("Enter phone number: ");
            String phoneNumber = scanner.nextLine();
            if (phoneNumber.isEmpty()) {
                throw new IllegalArgumentException("Error: Phone number cannot be empty.");
            }
            if (!isNumeric(phoneNumber)) {
                throw new IllegalArgumentException("Error: Phone number must be numeric.");
            }

            // Create Contact and display information
            Contact contact = new Contact(name, email, phoneNumber);
            contact.displayInfo();

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Program terminated.");
        }
    }

    // Helper method to validate email format
    private static boolean isValidEmail(String email) {
        return email.contains("@") && (email.endsWith(".com") || email.endsWith(".net") || email.endsWith(".org"));
    }

    // Helper method to check if a string is numeric
    private static boolean isNumeric(String str) {
        return str.matches("\\d+"); // Checks if the string consists only of digits
    }
}
