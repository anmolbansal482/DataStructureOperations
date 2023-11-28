import java.util.Scanner;

class Stack {
    private int maxSize;
    private int top;
    private int[] stackArray;
    
    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.stackArray = new int[maxSize];
        this.top = -1;
    }
    
    // Push operation to add an element to the stack
    public void push(int[] dataArr) {
        for (int data : dataArr) {
            if (top < maxSize - 1) {
                stackArray[++top] = data;
                System.out.println(data + " pushed onto the stack.");
            } else {
                System.out.println("Stack is full. Cannot push " + data + ".");
            }
        }
    }

    // Pop operation to remove the top element from the stack
    public void pop() {
        if (top >= 0) {
            int poppedItem = stackArray[top--];
            System.out.println(poppedItem + " popped from the stack.");
        } else {
            System.out.println("Stack is empty. Cannot pop.");
        }
    }

    // Top operation to get the top element of the stack without removing it
    public void top() {
        if (top >= 0) {
            System.out.println("Top element of the stack: " + stackArray[top]);
        } else {
            System.out.println("Stack is empty.");
        }
    }

    // Traversal operation to print the elements of the stack
    public void traverse() {
        if (top >= 0) {
            System.out.print("Stack: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("Stack is empty.");
        }
    }
}

public class IntStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the maximum size of the stack: ");
        int maxSize = scanner.nextInt();
        Stack stack = new Stack(maxSize);

        int choice;
        
        System.out.println("\nPlease choose from one of the options:");

        do {
            System.out.println("\n1. Push");
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
                    int[] dataArr = new int[dataStrArr.length];
                    for (int i = 0; i < dataStrArr.length; i++) {
                        dataArr[i] = Integer.parseInt(dataStrArr[i]);
                    }
                    stack.push(dataArr);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.top();
                    break;
                case 4:
                    stack.traverse();
                    break;
                case 5:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Please enter a valid option.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
