package level2;
import java.util.Scanner;
public class BankingApplication {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        BankAccount account = new BankAccount(
	                        10001,
	                        "Rahul",
	                        5000
	                );
	        BankService service = new BankService(account);
	        int choice;
	        do {
	            System.out.println("===== Simple Banking Application =====");
	            System.out.println("1. View Account Details");
	            System.out.println("2. Deposit Money");
	            System.out.println("3. Withdraw Money");
	            System.out.println("4. Check Balance");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");
	            choice = scanner.nextInt();
	            switch(choice) {
	                case 1:
	                    account.displayAccountDetails();
	                    break;
	                case 2:
	                    System.out.print(
	                            "Enter deposit amount: ");
	                    double depositAmount =
	                            scanner.nextDouble();
	                    service.depositMoney(depositAmount);
	                    break;
	                case 3:
	                    System.out.print(
	                            "Enter withdrawal amount: ");
	                    double withdrawAmount =
	                            scanner.nextDouble();
	                    service.withdrawMoney(withdrawAmount);
	                    break;
	                case 4:
	                    service.showBalance();
	                    break;
	                case 5:
	                    System.out.println(
	                            "Thank you for using Banking System");
	                    break;
	                default:
	                    System.out.println(
	                            "Invalid choice");
	            }
	        } while(choice != 5);
	        scanner.close();
	    }
	}
	class BankAccount {
	    private long accountNumber;
	    private String accountHolder;
	    private double balance;
	    public BankAccount(long accountNumber,
	                       String accountHolder,
	                       double balance) {
	        this.accountNumber = accountNumber;
	        this.accountHolder = accountHolder;
	        this.balance = balance;
	    }
	    public void deposit(double amount) {
	        if(amount <= 0) {
	            System.out.println(
	                    "Invalid deposit amount");
	            return;
	        }
	        balance += amount;
	        System.out.println(
	                "Amount deposited successfully");
	    }
	    public void withdraw(double amount) {
	        if(amount <= 0) {
	            System.out.println(
	                    "Invalid withdrawal amount");
	            return;
	        }
	        if(amount > balance) {
	            System.out.println(
	                    "Insufficient balance");
	            return;
	        }
	        balance -= amount;
	        System.out.println(
	                "Amount withdrawn successfully");
	    }
	    public void checkBalance() {
	        System.out.println(
	                "Current Balance: ₹" + balance);
	    }
	    public void displayAccountDetails() {
	        System.out.println(
	                "\nAccount Number: " + accountNumber);
	        System.out.println(
	                "Account Holder: " + accountHolder);
	        System.out.println(
	                "Balance: ₹" + balance);
	    }
	}
	class BankService {
	    private BankAccount account;
	    public BankService(BankAccount account) {
	        this.account = account;
	    }
	    public void depositMoney(double amount) {
	        account.deposit(amount);
	    }
	    public void withdrawMoney(double amount) {
	        account.withdraw(amount);
	    }
	    public void showBalance() {
	        account.checkBalance();
	    }
	}

