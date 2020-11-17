package ProjectEmployeeInArmy.Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    static String password = "dd1152138";
    static String userName = "postgres";
    static String connectionUrl = "jdbc:postgresql://localhost:5432/ProjectArmyEmployee";
    static String driver = "org.postgresql.Driver";


    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driver);
            System.out.println("Driver OK");
            connection = DriverManager.getConnection(connectionUrl, userName, password);
            System.out.println("Connection OK");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Connection ERROR");
        }
        return connection;
    }

}
