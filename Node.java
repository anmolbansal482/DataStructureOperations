import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}


class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    // Insert operation to add a node to the linked list
    public void insert(int[] dataArr) {
        for (int data : dataArr) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
            System.out.println(data + " inserted into the linked list.");
        }
    }

    // Delete operation to remove a node with a given data from the linked list
    public void delete(int data) {
        if (head == null) {
            System.out.println("List is empty. Cannot delete " + data + ".");
            return;
        }

        if (head.data == data) {
            head = head.next;
            System.out.println(data + " deleted from the linked list.");
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println(data + " not found in the linked list.");
        } else {
            current.next = current.next.next;
            System.out.println(data + " deleted from the linked list.");
        }
    }

    // Traversal operation to print the elements of the linked list
    public void traverse() {
        Node current = head;
        System.out.print("Linked List: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Scanner scanner = new Scanner(System.in);

        int choice;
        
        System.out.println("Please choose from one of the options:");
        
        do {
            System.out.println("\n1. Insert");
            System.out.println("2. Delete");
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
                    int[] dataArr = new int[dataStrArr.length];
                    for (int i = 0; i < dataStrArr.length; i++) {
                        dataArr[i] = Integer.parseInt(dataStrArr[i]);
                    }
                    linkedList.insert(dataArr);
                    break;
                case 2:
                    if (linkedList.head == null) {
                        System.out.println("List is empty. Cannot perform deletion.");
                    } else {
                        System.out.print("Enter data to delete: ");
                        int deleteData = scanner.nextInt();
                        linkedList.delete(deleteData);
                    }
                    break;
                case 3:
                    linkedList.traverse();
                    break;
                case 4:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 4);

        scanner.close();
    }
}
