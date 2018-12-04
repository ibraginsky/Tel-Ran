package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String DB = "mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "Craspric19812";
    private static final String TZ = "&serverTimezone=Asia/Jerusalem";
    private static final boolean SSL = false;

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL + "/" + DB + (SSL ? "" : "?useSSL=false") + TZ, USER, PASSWORD);
    }
}
