// this is not a best solution but this program does in this why for understanding only 
import java.util.Scanner;
public class FoodMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] items = {"Dosa", "Samosa", "Idli", "Vada", "Pav Bhaji"};
        int[] prices = {50, 20, 30, 25, 60};

        int totalBill = 0;
        int choice, qty;

        System.out.println("Welcome to Food Corner");
        System.out.println("Menu:");
        for (int i = 0; i < items.length; i++) {
            System.out.println((i + 1) + ". " + items[i] + " - Rs. " + prices[i]);
        }
        System.out.println("0. Generate Bill");

        while (true) {
            System.out.print("Enter your choice (0 to generate bill): ");
            choice = sc.nextInt();

            if (choice == 0) {
                break;
            }

            if (choice < 1 || choice > items.length) {
                System.out.println("Invalid choice! Please select again.");
                continue;
            }

            System.out.print("Enter quantity for " + items[choice - 1] + ": ");
            qty = sc.nextInt();

            int itemTotal = prices[choice - 1] * qty;
            totalBill += itemTotal;

            System.out.println(qty + " x " + items[choice - 1] + " added. Subtotal: Rs. " + itemTotal);
        }

        System.out.println("Total Bill Amount: Rs. " + totalBill);
        System.out.println("Thank you! Visit Again");
        sc.close();
    }
}
