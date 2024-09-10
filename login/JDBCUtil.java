package GiaoDien;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {

    public static Connection connect() {
        Connection connection = null;
        try {
            // Register the SQL Server JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Connection details for SQL Server
            String url = "jdbc:sqlserver://DESKTOP-UJM6TJ3\\SQLEXPRESS:1433;databaseName=login;user=sa;password=123;encrypt=true;trustServerCertificate=true;";
            String username = "sa";
            String password = "123";

            // Create the connection
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("\nConnection Successfully!");
        } catch (ClassNotFoundException | SQLException e) {
            handleSQLException(e);
        }
        return connection;
    }

    // ... (rest of the class remains unchanged)

    private static void handleSQLException(Exception e) {
        e.printStackTrace();
    }
}