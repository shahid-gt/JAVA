import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    static Connection conn = null;
    public static final String dbName = "javalddb";

    public static Connection connect() {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String username = "root";
            String password = "root@mysql";
            conn = DriverManager.getConnection(url + dbName, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
