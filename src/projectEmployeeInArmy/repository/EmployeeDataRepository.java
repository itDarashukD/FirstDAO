package projectEmployeeInArmy.repository;


import projectEmployeeInArmy.repository.connection.DataBaseConnection;
import projectEmployeeInArmy.repository.api.Idao;
import projectEmployeeInArmy.repository.model.EmployeeData;
import projectEmployeeInArmy.resources.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class EmployeeDataRepository  implements Idao<EmployeeData> {


    Logger logger = Logger.getLogger(EmployeeDataRepository.class.getName());

  //  private final DataBaseConnection dataBaseConnection = DataBaseConnection.getInstance();

    private final Connection connection =  DataBaseConnection.getInstance().getConnection();

    Constants constants = new Constants();

    @Override
    public void add(EmployeeData employeeData) throws SQLException {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(constants.getSQL_ADD_EMPLOYEE_DATA());

            preparedStatement.setLong(1, employeeData.getId());
            preparedStatement.setLong(2, employeeData.getYearsOld());
            preparedStatement.setString(3, employeeData.getEducation());
            preparedStatement.setString(4, employeeData.getCityLive());

            preparedStatement.executeUpdate();

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

            ResultSet resultSet = statement.executeQuery(constants.getSQL_GET_ALL_EMPLOYEE_DATA());

            while (resultSet.next()) {
                EmployeeData employeeData = new EmployeeData();

                employeeData.setId(resultSet.getLong(3));
                employeeData.setYearsOld(resultSet.getInt(4));
                employeeData.setEducation(resultSet.getString("education"));
                employeeData.setCityLive(resultSet.getString("cityLive"));

                list.add(employeeData);
            }

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
            preparedStatement = connection.prepareStatement(constants.getSQL_GET_BY_ID_EMPLOYEE_DATA());
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                employeeData.setId(resultSet.getLong("id"));
                employeeData.setYearsOld((int) resultSet.getLong("yearsOld"));
                employeeData.setEducation(resultSet.getString("education"));
                employeeData.setCityLive(resultSet.getString("cityLive"));

            }

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
            preparedStatement = connection.prepareStatement(constants.getSQL_UPDATE_EMPLOYEE_DATA());
            preparedStatement.setInt(1, employeeData.getYearsOld());
            preparedStatement.setString(2, employeeData.getEducation());
            preparedStatement.setString(3, employeeData.getCityLive());
            preparedStatement.setLong(4, employeeData.getId());

            preparedStatement.executeUpdate();

            logger.info("updating Complete  " + getAll());



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
            preparedStatement = connection.prepareStatement(constants.getSQL_GET_BY_ID_EMPLOYEE_DATA());

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

