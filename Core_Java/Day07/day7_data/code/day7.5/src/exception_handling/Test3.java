
package exception_handling;

import java.io.FileReader;
import java.util.Scanner;

public class Test3 {

    public static void main(String[] args) {

        // Try-with-resources: Automatically closes resources
        try (
            // Creates Scanner object to accept keyboard input
            Scanner sc = new Scanner(System.in);

            // Reads file path from user and opens the file
            FileReader reader = new FileReader(sc.nextLine())
        ) {

            // Accepts an integer from the user
            System.out.println("Enter number");

            System.out.println("Number " + sc.nextInt());

        }
        // JVM automatically calls close() on resources
        // Closing order is reverse of initialization:
        // 1. reader.close()
        // 2. sc.close()

        catch (Exception e) {

            // Handles exceptions if any occur
            System.out.println(e);
        }

    }
}

