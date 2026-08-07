package level2;
import java.util.ArrayList;
import java.util.Scanner;
class Employee {
	    private int id;
	    private String name;
	    private double salary;
	    private String department;
	    public Employee(int id, String name, double salary, String department) {
	        this.id = id;
	        this.name = name;
	        this.salary = salary;
	        this.department = department;
	    }
	    public int getId() {
	        return id;
	    }
	    public void setId(int id) {
	        this.id = id;
	    }
	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	    public double getSalary() {
	        return salary;
	    }
	    public void setSalary(double salary) {
	        this.salary = salary;
	    }
	    public String getDepartment() {
	        return department;
	    }
	    public void setDepartment(String department) {
	        this.department = department;
	    }
	    @Override
	    public String toString() {
	        return "ID: " + id + " | Name: " + name + " | Salary: $" + salary + " | Department: " + department;
	    }
	}
	public class EmployeeManagementSystem {
	    private ArrayList<Employee> employeeList;
	    public EmployeeManagementSystem() {
	        employeeList = new ArrayList<>();
	    }
	    public void addEmployee(Employee emp) {
	        if (findEmployeeById(emp.getId()) != null) {
	            System.out.println("Error: Employee with ID " + emp.getId() + " already exists.");
	            return;
	        }
	        employeeList.add(emp);
	        System.out.println("Employee added successfully!");
	    }
	    public void viewAllEmployees() {
	        if (employeeList.isEmpty()) {
	            System.out.println("No records found.");
	            return;
	        }
	        System.out.println("\n--- Employee Records ---");
	        for (Employee emp : employeeList) {
	            System.out.println(emp);
	        }
	    }
	    public void updateEmployee(int id, String newName, double newSalary, String newDepartment) {
	        Employee emp = findEmployeeById(id);
	        if (emp != null) {
	            emp.setName(newName);
	            emp.setSalary(newSalary);
	            emp.setDepartment(newDepartment);
	            System.out.println("Employee updated successfully!");
	        } else {
	            System.out.println("Error: Employee with ID " + id + " not found.");
	        }
	    }
	    public void deleteEmployee(int id) {
	        Employee emp = findEmployeeById(id);
	        if (emp != null) {
	            employeeList.remove(emp);
	            System.out.println("Employee removed successfully!");
	        } else {
	            System.out.println("Error: Employee with ID " + id + " not found.");
	        }
	    }
	    private Employee findEmployeeById(int id) {
	        for (Employee emp : employeeList) {
	            if (emp.getId() == id) {
	                return emp;
	            }
	        }
	        return null;
	    }
	    public static void main(String[] args) {
	        EmployeeManagementSystem ems = new EmployeeManagementSystem();
	        Scanner scanner = new Scanner(System.in);
	        boolean running = true;
	        while (running) {
	            System.out.println("=== Employee Management System ===");
	            System.out.println("1. Add Employee (Create)");
	            System.out.println("2. View All Employees (Read)");
	            System.out.println("3. Update Employee (Update)");
	            System.out.println("4. Delete Employee (Delete)");
	            System.out.println("5. Exit");
	            System.out.print("Choose an option (1-5): ");
	            int choice = scanner.nextInt();
	            scanner.nextLine();
	            switch (choice) {
	                case 1:
	                    System.out.print("Enter Employee ID: ");
	                    int id = scanner.nextInt();
	                    scanner.nextLine(); // Consume newline
	                    System.out.print("Enter Name: ");
	                    String name = scanner.nextLine();
	                    System.out.print("Enter Salary: ");
	                    double salary = scanner.nextDouble();
	                    scanner.nextLine(); // Consume newline
	                    System.out.print("Enter Department: ");
	                    String dept = scanner.nextLine();
	                    ems.addEmployee(new Employee(id, name, salary, dept));
	                    break;
	                case 2:
	                    ems.viewAllEmployees();
	                    break;
	                case 3:
	                    System.out.print("Enter Employee ID to Update: ");
	                    int updateId = scanner.nextInt();
	                    scanner.nextLine(); // Consume newline
	                    System.out.print("Enter New Name: ");
	                    String newName = scanner.nextLine();
	                    System.out.print("Enter New Salary: ");
	                    double newSalary = scanner.nextDouble();
	                    scanner.nextLine(); // Consume newline
	                    System.out.print("Enter New Department: ");
	                    String newDept = scanner.nextLine();
	                    ems.updateEmployee(updateId, newName, newSalary, newDept);
	                    break;
	                case 4:
	                    System.out.print("Enter Employee ID to Delete: ");
	                    int deleteId = scanner.nextInt();
	                    ems.deleteEmployee(deleteId);
	                    break;
	                case 5:
	                    running = false;
	                    System.out.println("Exiting System. Goodbye!");
	                    break;
	                default:
	                    System.out.println("Invalid option. Please choose between 1 and 5.");
	            }
	        }
	        scanner.close();
	    }
	}
