import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void displayAllEmployees() throws SQLException {
        List<Employee> empList = EmployeeDao.readAllEmployees();
        for (Employee emp : empList) {
            System.out.println("\nID: " + emp.getId() + "\nName: " + emp.getName() + "\nDesignation: " + emp.getDesignation());
        }
    }

    public static void main(String[] args) {
        try {
            displayAllEmployees();
            EmployeeDao.insertEmployee(new Employee(2, "priyank.shah", "TPM" ));
            EmployeeDao.insertEmployee(new Employee(4, "faizan.momin", "SE" ));
            System.out.println("After inserting ID 4 and 5 employees");
            displayAllEmployees();
            EmployeeDao.updateEmployee(new Employee(2,"priyank.shah2", "STPM"));
            EmployeeDao.updateEmployee(new Employee(4, "faizan.momin", "SSE" ));
            System.out.println("After updating the 4 and 5 employees");
            displayAllEmployees();
            EmployeeDao.deleteEmployee(new Employee(3));
            System.out.println("After deleting 3rd employee");
            displayAllEmployees();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}