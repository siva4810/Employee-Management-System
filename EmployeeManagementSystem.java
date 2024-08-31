import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagementSystem {
    private ArrayList<Employee> employees;
    private Scanner scanner;

    public EmployeeManagementSystem() {
        employees = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addEmployee() {
        System.out.println("Enter employee ID:");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.println("Enter employee name:");
        String name = scanner.nextLine();

        System.out.println("Enter employee position:");
        String position = scanner.nextLine();

        System.out.println("Enter employee salary:");
        double salary = scanner.nextDouble();

        Employee employee = new Employee(id, name, position, salary);
        employees.add(employee);
        System.out.println("Employee added successfully!");
    }

    public void viewEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void updateEmployee() {
        System.out.println("Enter employee ID to update:");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (Employee employee : employees) {
            if (employee.getId() == id) {
                System.out.println("Enter new name:");
                employee.setName(scanner.nextLine());

                System.out.println("Enter new position:");
                employee.setPosition(scanner.nextLine());

                System.out.println("Enter new salary:");
                employee.setSalary(scanner.nextDouble());

                System.out.println("Employee updated successfully!");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem();
        boolean running = true;

        while (running) {
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Exit");

            int choice = system.scanner.nextInt();
            switch (choice) {
                case 1:
                    system.addEmployee();
                    break;
                case 2:
                    system.viewEmployees();
                    break;
                case 3:
                    system.updateEmployee();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
