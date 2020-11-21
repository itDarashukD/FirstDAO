package ProjectEmployeeInArmy.resources;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;


public class Settings {
    public String getPropertiesValue(String propertyName) {

        String propertyValue = "";
        Properties properties = new Properties();

        try (InputStream inputStream = this.getClass().getResourceAsStream("DBConnection.properties")) {
            properties.load(inputStream);
            propertyValue = properties.getProperty(propertyName);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return propertyValue;
    }
}





