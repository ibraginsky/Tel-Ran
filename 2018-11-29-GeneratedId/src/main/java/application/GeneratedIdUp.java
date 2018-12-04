package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionDB;

public class GeneratedIdUp {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        String dbReq = "INSERT INTO gen_id (name) VALUES ('Glasha');";
        String[] returnedFieleds = {"id"};

        PreparedStatement pStatement = connection.prepareStatement(dbReq, returnedFieleds);
        pStatement.executeUpdate();

        ResultSet rs = pStatement.getGeneratedKeys();
        rs.next();
        System.out.println(rs.getInt(1));
    }
}
