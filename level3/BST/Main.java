package level3.BST;
import java.util.Scanner;
public class Main {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        BinarySearchTree bst = new BinarySearchTree();
	        int choice;
	        do {
	            System.out.println("===== Binary Search Tree =====");
	            System.out.println("1. Insert");
	            System.out.println("2. Search");
	            System.out.println("3. Delete");
	            System.out.println("4. Inorder Traversal");
	            System.out.println("5. Preorder Traversal");
	            System.out.println("6. Postorder Traversal");
	            System.out.println("7. Exit");
	            System.out.print("Enter Choice: ");
	            choice = sc.nextInt();
	            switch (choice) {
	            case 1:
	                System.out.print("Enter value: ");
	                int value = sc.nextInt();
	                bst.root = bst.insert(bst.root, value);
	                System.out.println("Node Inserted Successfully");
	                break;
	            case 2:
	                System.out.print("Enter value to search: ");
	                int key = sc.nextInt();
	                if (bst.search(bst.root, key))
	                    System.out.println("Node Found");
	                else
	                    System.out.println("Node Not Found");
	                break;
	            case 3:
	                System.out.print("Enter value to delete: ");
	                int deleteValue = sc.nextInt();
	                bst.root = bst.delete(bst.root, deleteValue);
	                System.out.println("Node Deleted Successfully");
	                break;
	            case 4:
	                System.out.print("Inorder Traversal: ");
	                bst.inorder(bst.root);
	                System.out.println();
	                break;
	            case 5:
	                System.out.print("Preorder Traversal: ");
	                bst.preorder(bst.root);
	                System.out.println();
	                break;
	            case 6:
	                System.out.print("Postorder Traversal: ");
	                bst.postorder(bst.root);
	                System.out.println();
	                break;
	            case 7:
	                System.out.println("Application Closed");
	                break;
	            default:
	                System.out.println("Invalid Choice");
	            }
	        } while (choice != 7);
	        sc.close();
	    }
	}

