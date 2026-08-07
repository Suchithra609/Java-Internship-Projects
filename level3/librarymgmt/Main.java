package level3.librarymgmt;
import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        LibraryService service=new LibraryService();
        int choice;
        do{
            System.out.println("===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Add User");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Enter Choice:");
            choice=sc.nextInt();
            switch(choice){
            case 1:
                sc.nextLine();
                System.out.print("Book Title:");
                String title=sc.nextLine();
                System.out.print("Author:");
                String author=sc.nextLine();
                service.addBook(
                new Book(title,author,true));
                break;
            case 2:
                service.viewBooks();
                break;
            case 3:
                sc.nextLine();
                System.out.print("Name:");
                String name=sc.nextLine();
                System.out.print("Email:");
                String email=sc.nextLine();
                service.addUser(
                new User(name,email));
                break;
            case 4:
                System.out.print("User ID:");
                int uid=sc.nextInt();
                System.out.print("Book ID:");
                int bid=sc.nextInt();
                service.borrowBook(uid,bid);
                break;
            case 5:
                System.out.print("Book ID:");
                int id=sc.nextInt();
                service.returnBook(id);
                break;
            case 6:
                System.out.println("Thank You!");
                break;
            default:
                System.out.println("Invalid Choice");
            }
        }while(choice!=6);
        sc.close();
    }
}