package projectEmployeeInArmy.repository.connection;

import projectEmployeeInArmy.resources.Settings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DataBaseConnection {
    private static Logger logger = Logger.getLogger(DataBaseConnection.class.getName());

    private static DataBaseConnection instance;
    public Connection connection;
    static String password = new Settings().getPropertiesValue("password");
    static String userName = new Settings().getPropertiesValue("userName");
    static String connectionUrl = new Settings().getPropertiesValue("connectionUrl");
    static String driver = new Settings().getPropertiesValue("driver");


    public DataBaseConnection() {
        try {
            Class.forName(driver);
            this.connection = DriverManager.getConnection(connectionUrl, userName, password);

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {

        return connection;
    }

    public static DataBaseConnection getInstance() throws SQLException {
        if (instance == null) {

            instance = new DataBaseConnection();

        } else if (instance.getConnection().isClosed()) {
            instance = new DataBaseConnection();

        }

        return instance;
    }

    public static void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();

            logger.info("Connection was closed");
        }
    }
}


