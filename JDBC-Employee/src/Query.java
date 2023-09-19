public class Query {
    static String createTable = "CREATE TABLE employees (id int, name varchar(255), designation varchar(255))";
    static String insert = "INSERT INTO employees (id, name, designation) VALUES (?, ?, ?)";
    static String update = "UPDATE employees SET name = ?, designation = ? WHERE id = ?";
    static String delete = "DELETE FROM employees WHERE id = ?";
    static String select = "SELECT * FROM employees";
}
