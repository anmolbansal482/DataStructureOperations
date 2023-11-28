import java.util.PriorityQueue;
import java.util.Scanner;

public class Heap {
    public static void main(String[] args) {
        PriorityQueue<Integer> Heap = new PriorityQueue<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose from one of the options:");
        int choice;

        do {
            System.out.println("\n1. Insert");
            System.out.println("2. Extract Min");
            System.out.println("3. Traversal");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter integers to insert: ");
                    scanner.nextLine(); // Consume newline character
                    String input = scanner.nextLine();
                    String[] dataStrArr = input.split("\\s+");
                    for (String dataStr : dataStrArr) {
                        int data = Integer.parseInt(dataStr);
                        Heap.offer(data);
                        System.out.println(data + " inserted into the heap.");
                    }
                    break;
                case 2:
                    if (!Heap.isEmpty()) {
                        int extractedMin = Heap.poll();
                        System.out.println("Min element extracted from the min-heap: " + extractedMin);
                    } else {
                        System.out.println("Heap is empty. Cannot extract min.");
                    }
                    break;
                case 3:
                    System.out.print("Min-Heap: ");
                    for (int item : Heap) {
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
