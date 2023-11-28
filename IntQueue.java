import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IntQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        
        int choice;
        
        System.out.println("Please choose from one of the options:");
        
        do {
            System.out.println("\n1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Traversal");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter integers to enqueue: ");
                    scanner.nextLine(); // Consume newline character
                    String input = scanner.nextLine();
                    String[] dataStrArr = input.split("\\s+");
                    for (String dataStr : dataStrArr) {
                        int data = Integer.parseInt(dataStr);
                        queue.add(data);
                        System.out.println(data + " enqueued into the queue.");
                    }
                    break;
                case 2:
                    if (!queue.isEmpty()) {
                        int dequeuedItem = queue.poll();
                        System.out.println(dequeuedItem + " dequeued from the queue.");
                    } else {
                        System.out.println("Queue is empty. Cannot dequeue.");
                    }
                    break;
                case 3:
                    System.out.print("Queue: ");
                    for (int item : queue) {
                        System.out.print(item + " ");
                    }
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Please enter a valid option.");
            }

        } while (choice != 4);

        scanner.close();
    }
}
