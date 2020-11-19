package ProjectEmployeeInArmy.repository.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class ConnectionDataBase {
    Logger logger = Logger.getLogger(ConnectionDataBase.class.getName());

    static String password = "dd1152138";
    static String userName = "postgres";
    static String connectionUrl = "jdbc:postgresql://localhost:5432/ProjectArmyEmployee";
    static String driver = "org.postgresql.Driver";


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

        logger.info("Connection was closed");          }
    }
}