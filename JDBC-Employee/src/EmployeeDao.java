import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {


    public static void createTable() throws SQLException {
        Connection conn = DB.connect();
        Statement stm = conn.createStatement();
        stm.execute(Query.createTable);
        System.out.println("Table employee Created successfully");
    }

    public static void insertEmployee(Employee e) throws SQLException {
        Connection conn = DB.connect();
        PreparedStatement pstm = conn.prepareStatement(Query.insert);
        pstm.setInt(1, e.getId());
        pstm.setString(2, e.getName());
        pstm.setString(3, e.getDesignation());
        int rowAffected = pstm.executeUpdate();
        if (rowAffected == -1) System.out.println("insertEmployee: No rows affected while updating.");
        else
            System.out.println("insertEmployee: number of rows affected: " + rowAffected + "\nEmployee " + e.toString() + " inserted successfully");
    }

    public static void updateEmployee(Employee e) throws SQLException {
        Connection conn = DB.connect();
        PreparedStatement pstm = conn.prepareStatement(Query.update);
        pstm.setString(1, e.getName());
        pstm.setString(2, e.getDesignation());
        pstm.setInt(3, e.getId());
        int rowsAffected = pstm.executeUpdate();
        if (rowsAffected == -1) System.out.println("updateEmployee: No rows affected while updating.");
        else System.out.println("updateEmployee: number of rows affected: " + rowsAffected + "\nEmployee " + e.toString() + " updated successfully");
    }

    public static void deleteEmployee(Employee e) throws SQLException {
        Connection conn = DB.connect();
        PreparedStatement pstm = conn.prepareStatement(Query.delete);
        pstm.setInt(1, e.getId());
        int rowsAffected = pstm.executeUpdate();
        if (rowsAffected == -1) System.out.println("deleteEmployee: No rows affected while updating.");
        else
            System.out.println("deleteEmployee: number of rows affected: " + rowsAffected + "\nEmployee with ID " + e.getId() + " deleted successfully");
    }

    public static List<Employee> readAllEmployees() throws SQLException {
        List<Employee> response = new ArrayList<>();
        Connection conn = DB.connect();
        Statement stm = conn.createStatement();
        ResultSet resultSet = stm.executeQuery(Query.select);
        while (resultSet.next())
            response.add(new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
        return response;
    }

}
