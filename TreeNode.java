import java.util.Scanner;

class TreeNode {
    int key;
    TreeNode left, right;

    public TreeNode(int key) {
        this.key = key;
        this.left = this.right = null;
    }
}

class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    // Insert operation to add a key to the BST
    public void insert(int key) {
        root = insertRec(root, key);
        System.out.println(key + " inserted into the Binary Search Tree.");
    }

    private TreeNode insertRec(TreeNode root, int key) {
        if (root == null) {
            return new TreeNode(key);
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    // Delete operation to remove a key from the BST
    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private TreeNode deleteRec(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children
            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    private int minValue(TreeNode root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    // Find operation to check if a key is present in the BST
    public boolean find(int key) {
        return findRec(root, key);
    }

    private boolean findRec(TreeNode root, int key) {
        if (root == null) {
            return false;
        }

        if (key == root.key) {
            return true;
        } else if (key < root.key) {
            return findRec(root.left, key);
        } else {
            return findRec(root.right, key);
        }
    }

    // Inorder traversal to print the keys in sorted order
    public void inorderTraversal() {
        System.out.print("Inorder Traversal: ");
        inorderTraversalRec(root);
        System.out.println();
    }

    private void inorderTraversalRec(TreeNode root) {
        if (root != null) {
            inorderTraversalRec(root.left);
            System.out.print(root.key + " ");
            inorderTraversalRec(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);

        int choice;
        
        System.out.println("Please choose from one of the options:");
        
        do {
            System.out.println("\n1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Inorder Traversal");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter key to insert: ");
                    int insertKey = scanner.nextInt();
                    bst.insert(insertKey);
                    break;
                case 2:
                    System.out.print("Enter key to delete: ");
                    int deleteKey = scanner.nextInt();
                    bst.delete(deleteKey);
                    break;
                case 3:
                    System.out.println("Binary Search Tree Inorder Traversal:");
                    bst.inorderTraversal();
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
