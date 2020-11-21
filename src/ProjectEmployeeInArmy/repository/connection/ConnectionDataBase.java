package ProjectEmployeeInArmy.repository.connection;

import ProjectEmployeeInArmy.resources.Settings;
import com.sun.deploy.security.CertStore;
import sun.util.logging.resources.logging;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public class ConnectionDataBase {

    Logger logger = Logger.getLogger(ConnectionDataBase.class.getName());



    static String password =  new Settings().getPropertiesValue("password");
    static String userName =  new Settings().getPropertiesValue("userName");
    static String connectionUrl = new Settings().getPropertiesValue("connectionUrl");
    static String driver =  new Settings().getPropertiesValue("driver");


    public Connection getConnection() {

        Connection connection = null;
        try {
            Class.forName(driver);
            logger.info("Driver OK!");

            connection = DriverManager.getConnection(connectionUrl, userName, password);
            logger.info("Connection OK");
        } catch (ClassNotFoundException | SQLException e) {

            logger.info("Connection ERROR!" + e);

        }
        return connection;
    }

    public void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();

            logger.info("Connection was closed");
        }
    }
}