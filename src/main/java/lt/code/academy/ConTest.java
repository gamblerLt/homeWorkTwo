package lt.code.academy;

import lt.code.academy.conn.ConnectionProperties;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConTest {
    private final Connection connection;

    public ConTest(Connection connection) {
        this.connection = connection;
    }

    public static void main(String[] args) throws SQLException {

        ConnectionProperties properties = ConnectionProperties.getInstance();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(properties.getValue("jdbc.postgresql.connection.url"),
                    properties.getValue("jdbc.postgresql.connection.name"),
                    properties.getValue("jdbc.postgresql.connection.password"));
            if (connection != null) {
                System.out.println("Prisijungeme prie postgresql DB...");
            }
        }catch (Exception e) {

            System.out.println(e.getMessage());

        }
    }


}
