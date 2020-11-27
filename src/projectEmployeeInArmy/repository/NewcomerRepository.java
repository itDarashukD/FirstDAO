package projectEmployeeInArmy.repository;


import projectEmployeeInArmy.repository.api.Idao;
import projectEmployeeInArmy.repository.connection.DataBaseConnection;
import projectEmployeeInArmy.repository.model.EmployeeNewcomer;
import projectEmployeeInArmy.resources.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class NewcomerRepository implements Idao<EmployeeNewcomer> {

    private final Logger logger = Logger.getLogger(NewcomerRepository.class.getName());

    DataBaseConnection dataBaseConnection =DataBaseConnection.getInstance();

    Constants constants = new Constants();

    public final Connection connection = dataBaseConnection.getConnection();

    @Override
    public void add(EmployeeNewcomer employeeNewcomer)   {

        try (PreparedStatement preparedStatement = connection.prepareStatement(constants.getSQL_ADD_NEWCOMER())) {

            preparedStatement.setLong(1, employeeNewcomer.getId());
            preparedStatement.setString(2, employeeNewcomer.getFirstName());
            preparedStatement.setString(3, employeeNewcomer.getLastName());
            preparedStatement.setLong(4, employeeNewcomer.getYears_old());

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    @Override
    public List<EmployeeNewcomer> getAll() {
        List<EmployeeNewcomer> list = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(constants.getSQL_GET_ALL_NEWCOMER());

            while (resultSet.next()) {
                EmployeeNewcomer employeeNewcomer1 = new EmployeeNewcomer();
                employeeNewcomer1.setId(resultSet.getLong(1));
                employeeNewcomer1.setFirstName(resultSet.getString(2));
                employeeNewcomer1.setLastName(resultSet.getString(3));
                employeeNewcomer1.setYears_old(resultSet.getInt(4));

                list.add(employeeNewcomer1);
            }


        } catch (SQLException e) {
            e.printStackTrace();

        }
        return list;
    }

    @Override
    public EmployeeNewcomer getById(long id)   {
        EmployeeNewcomer newcomer = new EmployeeNewcomer();


        try (PreparedStatement preparedStatement = connection.prepareStatement(constants.getSQL_GET_BY_ID_NEWCOMER())) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                newcomer.setId(resultSet.getLong(1));
                newcomer.setFirstName(resultSet.getString(2));
                newcomer.setLastName(resultSet.getString(3));
                newcomer.setYears_old(resultSet.getInt(4));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newcomer;
    }


    @Override
    public void update(EmployeeNewcomer employeeNewcomer)   {


        try (PreparedStatement preparedStatement = connection.prepareStatement(constants.getSQL_UPDATE_NEWCOMER())) {


            preparedStatement.setString(1, employeeNewcomer.getFirstName());
            preparedStatement.setString(2, employeeNewcomer.getLastName());
            preparedStatement.setInt(3, employeeNewcomer.getYears_old());
            preparedStatement.setLong(4, employeeNewcomer.getId());

            preparedStatement.executeUpdate();

            logger.info("updating complete  " + getAll());



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(long id)   {

        try (PreparedStatement preparedStatement = connection.prepareStatement(constants.getSQL_DELETE_NEWCOMER())) {

            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

            logger.info("Deleting Complete  " + getAll());


        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}