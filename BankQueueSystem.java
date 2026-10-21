import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Bank Queue Management System
 * Student Index Number: PS/ITC/24/0290
 * Demonstrates a FIFO queue using Java.
 */
public class BankQueueSystem {
    public static void main(String[] args) {
        Queue<String> customers = new LinkedList<>();
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== BANK QUEUE MANAGEMENT SYSTEM =====");
            System.out.println("Student Index Number: PS/ITC/24/0290");
            System.out.println("1. Add customer to queue");
            System.out.println("2. Serve next customer");
            System.out.println("3. Display waiting customers");
            System.out.println("4. View next customer");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            while (!input.hasNextInt()) {
                System.out.print("Please enter a number from 1 to 5: ");
                input.next();
            }
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = input.nextLine().trim();
                    if (!name.isEmpty()) {
                        customers.offer(name);
                        System.out.println(name + " has been added to the queue.");
                    } else {
                        System.out.println("Customer name cannot be empty.");
                    }
                    break;
                case 2:
                    String served = customers.poll();
                    System.out.println(served == null
                            ? "No customers are waiting."
                            : "Now serving: " + served);
                    break;
                case 3:
                    if (customers.isEmpty()) {
                        System.out.println("The queue is empty.");
                    } else {
                        System.out.println("Waiting customers: " + customers);
                    }
                    break;
                case 4:
                    String next = customers.peek();
                    System.out.println(next == null
                            ? "No customers are waiting."
                            : "Next customer: " + next);
                    break;
                case 5:
                    System.out.println("Thank you for using the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Choose from 1 to 5.");
            }
        } while (choice != 5);

        input.close();
    }
}
