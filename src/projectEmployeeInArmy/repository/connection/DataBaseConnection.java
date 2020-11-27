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

   // private static Settings settings = Settings.getInstance();

    private String password = Settings.getInstance().getPropertiesValue("password");
    private String userName = Settings.getInstance().getPropertiesValue("userName");
    private String connectionUrl = Settings.getInstance().getPropertiesValue("connectionUrl");
    private String driver = Settings.getInstance().getPropertiesValue("driver");

    private DataBaseConnection() {
        open();
    }


    public Connection getConnection() {

        return connection;
    }

    public static DataBaseConnection getInstance() {
        if (instance == null) {
            instance = new DataBaseConnection();
        }
        return instance;
    }


    public void open() {
        try {
            Class.forName(driver);
            this.connection = DriverManager.getConnection(connectionUrl, userName, password);

        } catch (ClassNotFoundException | SQLException ex) {
            logger.info("Database Connection Creation Failed : " + ex.getMessage());

        }
    }

    public void close() throws SQLException {
        if (connection != null) {
            connection.close();

            logger.info("Connection was closed");
        }
    }
}

