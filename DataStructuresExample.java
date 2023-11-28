import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListOperations {
    private ListNode head;

    public LinkedListOperations() {
        this.head = null;
    }

    public void insert(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println(data + " inserted into the linked list.");
    }

    public void delete(int data) {
        if (head == null) {
            System.out.println("Linked list is empty. Cannot delete.");
            return;
        }

        if (head.data == data) {
            head = head.next;
            System.out.println(data + " deleted from the linked list.");
            return;
        }

        ListNode current = head;
        ListNode prev = null;

        while (current != null && current.data != data) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println(data + " not found in the linked list. Cannot delete.");
        } else {
            prev.next = current.next;
            System.out.println(data + " deleted from the linked list.");
        }
    }

    public void traverse() {
        ListNode current = head;
        System.out.print("Linked List: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class BinarySearchTree {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int data) {
        root = insertRecursive(root, data);
        System.out.println(data + " inserted into the binary search tree.");
    }

    private TreeNode insertRecursive(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        }

        if (data < root.data) {
            root.left = insertRecursive(root.left, data);
        } else if (data > root.data) {
            root.right = insertRecursive(root.right, data);
        }

        return root;
    }

    public void delete(int data) {
        TreeNode[] result = deleteRecursive(root, data);
        root = result[0];
        if (result[1] != null) {
            System.out.println(data + " deleted from the binary search tree.");
        } else {
            System.out.println(data + " not found in the binary search tree. Cannot delete.");
        }
    }

    private TreeNode[] deleteRecursive(TreeNode root, int data) {
        TreeNode[] result = new TreeNode[2];
        result[0] = root;
        result[1] = null;

        if (root == null) {
            return result;
        }

        if (data < root.data) {
            root.left = deleteRecursive(root.left, data);
        } else if (data > root.data) {
            root.right = deleteRecursive(root.right, data);
        } else {
            result[1] = root;
            if (root.left == null) {
                return new TreeNode[]{root.right, result[1]};
            } else if (root.right == null) {
                return new TreeNode[]{root.left, result[1]};
            }

            TreeNode successor = findMin(root.right);
            root.data = successor.data;
            root.right = deleteRecursive(root.right, successor.data);
        }

        return result;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public boolean search(int data) {
        return searchRecursive(root, data);
    }

    private boolean searchRecursive(TreeNode root, int data) {
        if (root == null) {
            return false;
        }

        if (data == root.data) {
            return true;
        } else if (data < root.data) {
            return searchRecursive(root.left, data);
        } else {
            return searchRecursive(root.right, data);
        }
    }

    public void inorderTraversal() {
        System.out.print("Binary Search Tree (Inorder Traversal): ");
        inorderTraversalRecursive(root);
        System.out.println();
    }

    private void inorderTraversalRecursive(TreeNode root) {
        if (root != null) {
            inorderTraversalRecursive(root.left);
            System.out.print(root.data + " ");
            inorderTraversalRecursive(root.right);
        }
    }
}

public class DataStructuresExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack<Integer> dynamicStack = new Stack<>();
        Queue<Integer> dynamicQueue = new LinkedList<>();
        PriorityQueue<Integer> dynamicMinHeap = new PriorityQueue<>();
        LinkedListOperations linkedList = new LinkedListOperations();
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        int choice;

        do {
            System.out.println("\nChoose a data structure function:");
            System.out.println("\n1. Stack");
            System.out.println("2. Queue");
            System.out.println("3. Min-Heap");
            System.out.println("4. Linked List");
            System.out.println("5. Binary Search Tree");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    operateDynamicStack(dynamicStack, scanner);
                    break;
                case 2:
                    operateDynamicQueue(dynamicQueue, scanner);
                    break;
                case 3:
                    operateDynamicMinHeap(dynamicMinHeap, scanner);
                    break;
                case 4:
                    operateLinkedList(linkedList, scanner);
                    break;
                case 5:
                    operateBinarySearchTree(binarySearchTree, scanner);
                    break;
                case 6:
                    System.out.println("Exiting!");
                    break;
                default:
                    System.out.println("Please enter a valid option.");
            }

        } while (choice != 6);

        scanner.close();
    }

    private static void operateBinarySearchTree(BinarySearchTree binarySearchTree, Scanner scanner) {
		// TODO Auto-generated method stub
		
	}

	private static void operateLinkedList(LinkedListOperations linkedList, Scanner scanner) {
		// TODO Auto-generated method stub
		
	}

	private static void operateDynamicStack(Stack<Integer> stack, Scanner scanner) {
        int choice;

        do {
            System.out.println("\nStack Operations:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Top");
            System.out.println("4. Traversal");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter integers to push: ");
                    scanner.nextLine(); // Consume newline character
                    String input = scanner.nextLine();
                    String[] dataStrArr = input.split("\\s+");
                    for (String dataStr : dataStrArr) {
                        int data = Integer.parseInt(dataStr);
                        stack.push(data);
                        System.out.println(data + " pushed onto the stack.");
                    }
                    break;
                case 2:
                    if (!stack.isEmpty()) {
                        int poppedItem = stack.pop();
                        System.out.println(poppedItem + " popped from the stack.");
                    } else {
                        System.out.println("Stack is empty. Cannot pop.");
                    }
                    break;
                case 3:
                    if (!stack.isEmpty()) {
                        System.out.println("Top element of the stack: " + stack.peek());
                    } else {
                        System.out.println("Stack is empty.");
                    }
                    break;
                case 4:
                    System.out.print("Stack: ");
                    for (int item : stack) {
                        System.out.print(item + " ");
                    }
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Exiting Dynamic Stack Operations.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 5);
    }

    private static void operateDynamicQueue(Queue<Integer> queue, Scanner scanner) {
        int choice;

        do {
            System.out.println("\nDynamic Queue Operations:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Traversal");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter space-separated integers to enqueue: ");
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
                    System.out.println("Exiting Dynamic Queue Operations.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 4);
    }

    private static void operateDynamicMinHeap(PriorityQueue<Integer> minHeap, Scanner scanner) {
        int choice;

        do {
            System.out.println("\nDynamic Min-Heap Operations:");
            System.out.println("1. Insert");
            System.out.println("2. Extract Min");
            System.out.println("3. Traversal");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter space-separated integers to insert: ");
                    scanner.nextLine(); // Consume newline character
                    String input = scanner.nextLine();
                    String[] dataStrArr = input.split("\\s+");
                    for (String dataStr : dataStrArr) {
                        int data = Integer.parseInt(dataStr);
                        minHeap.offer(data);
                        System.out.println(data + " inserted into the min-heap.");
                    }
                    break;
                case 2:
                    if (!minHeap.isEmpty()) {
                        int extractedMin = minHeap.poll();
                        System.out.println("Min element extracted from the min-heap: " + extractedMin);
                    } else {
                        System.out.println("Min-heap is empty. Cannot extract min.");
                    }
                    break;
                case 3:
                    System.out.print("Min-Heap: ");
                    for (int item : minHeap) {
                        System.out.print(item + " ");
                    }
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Exiting Dynamic Min-Heap Operations.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 5);
        	scanner.close();
    }
}
