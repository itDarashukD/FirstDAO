package projectEmployeeInArmy.repository;

//import projectEmployeeInArmy.repository.connection.ConnectionDataBase;
import projectEmployeeInArmy.repository.connection.DataBaseConnection;
import projectEmployeeInArmy.repository.api.Idao;
import projectEmployeeInArmy.repository.model.EmployeeData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class EmployeeDataRepository  implements Idao<EmployeeData> {

    String sqlAdd = "INSERT INTO employee_data (id, yearsold, education, citylive) VALUES(?, ?, ?, ?)";
    String sqlGetAll = "SELECT * FROM employee_data";
    String sqlGetById = "SELECT * FROM employee_data WHERE id=?";
    String sqlUpdate = "UPDATE employee_data SET  yearsOld=?, education=?, cityLive=? WHERE id=?";
    String sqlDelete = "DELETE FROM employee_data WHERE id=?";

    Logger logger = Logger.getLogger(EmployeeDataRepository.class.getName());
    DataBaseConnection dataBaseConnection=new DataBaseConnection();

    public final Connection connection =  dataBaseConnection.getConnection();

    @Override
    public void add(EmployeeData employeeData) throws SQLException {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sqlAdd);

            preparedStatement.setLong(1, employeeData.getId());
            preparedStatement.setLong(2, employeeData.getYearsOld());
            preparedStatement.setString(3, employeeData.getEducation());
            preparedStatement.setString(4, employeeData.getCityLive());

            preparedStatement.executeUpdate();
          //  closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

    }

    @Override
    public List<EmployeeData> getAll() throws SQLException {

        List<EmployeeData> list = new ArrayList<>();

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sqlGetAll);

            while (resultSet.next()) {
                EmployeeData employeeData = new EmployeeData();

                employeeData.setId(resultSet.getLong(3));
                employeeData.setYearsOld(resultSet.getInt(4));
                employeeData.setEducation(resultSet.getString("education"));
                employeeData.setCityLive(resultSet.getString("cityLive"));

                list.add(employeeData);
            }
     //       closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        return list;
    }

    @Override
    public EmployeeData getById(long id) throws SQLException {

        PreparedStatement preparedStatement = null;

        EmployeeData employeeData = new EmployeeData();
        try {
            preparedStatement = connection.prepareStatement(sqlGetById);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                employeeData.setId(resultSet.getLong("id"));
                employeeData.setYearsOld((int) resultSet.getLong("yearsOld"));
                employeeData.setEducation(resultSet.getString("education"));
                employeeData.setCityLive(resultSet.getString("cityLive"));

            }
       //     closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }

        }
        return employeeData;
    }


    @Override
    public void update(EmployeeData employeeData) throws SQLException {

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setInt(1, employeeData.getYearsOld());
            preparedStatement.setString(2, employeeData.getEducation());
            preparedStatement.setString(3, employeeData.getCityLive());
            preparedStatement.setLong(4, employeeData.getId());

            preparedStatement.executeUpdate();

            logger.info("updating Complete  " + getAll());

      //      closeConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }

        }
    }

    @Override
    public void delete(long id) throws SQLException {

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sqlDelete);

            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();

            logger.info("Deleting Complete  " + getAll());

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }

        }

    }
}

