package projectEmployeeInArmy.repository;


import projectEmployeeInArmy.repository.api.Idao;
import projectEmployeeInArmy.repository.connection.DataBaseConnection;
import projectEmployeeInArmy.repository.model.EmployeeNewcomer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class NewcomerRepository implements Idao<EmployeeNewcomer> {

    String sqlAdd = "INSERT INTO newcomer ( id,first_name,last_name,years_old) VALUES (?,?,?,?)";
    String sqlGetAll = "SELECT * FROM newcomer";
    String sqlGetById = "SELECT * FROM newcomer WHERE id=?";
    String sqlUpdate = "UPDATE newcomer SET first_name=?,last_name=?,years_old=? WHERE id=?";
    String sqlDelete = "DELETE FROM newcomer WHERE id=?";


    private final Logger logger = Logger.getLogger(NewcomerRepository.class.getName());

    DataBaseConnection dataBaseConnection = new DataBaseConnection();

    public final Connection connection = dataBaseConnection.getConnection();

    @Override
    public void add(EmployeeNewcomer employeeNewcomer) throws SQLException {

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlAdd)) {

            preparedStatement.setLong(1, employeeNewcomer.getId());
            preparedStatement.setString(2, employeeNewcomer.getFirstName());
            preparedStatement.setString(3, employeeNewcomer.getLastName());
            preparedStatement.setLong(4, employeeNewcomer.getYears_old());

            preparedStatement.executeUpdate();
            //  closeConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    @Override
    public List<EmployeeNewcomer> getAll() throws SQLException {
        List<EmployeeNewcomer> list = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sqlGetAll);

            while (resultSet.next()) {
                EmployeeNewcomer employeeNewcomer1 = new EmployeeNewcomer();
                employeeNewcomer1.setId(resultSet.getLong(1));
                employeeNewcomer1.setFirstName(resultSet.getString(2));
                employeeNewcomer1.setLastName(resultSet.getString(3));
                employeeNewcomer1.setYears_old(resultSet.getInt(4));

                list.add(employeeNewcomer1);
            }
            //   closeConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return list;
    }

    @Override
    public EmployeeNewcomer getById(long id) throws SQLException {
        EmployeeNewcomer newcomer = new EmployeeNewcomer();


        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlGetById)) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                newcomer.setId(resultSet.getLong(1));
                newcomer.setFirstName(resultSet.getString(2));
                newcomer.setLastName(resultSet.getString(3));
                newcomer.setYears_old(resultSet.getInt(4));
            }
            //    closeConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newcomer;
    }


    @Override
    public void update(EmployeeNewcomer employeeNewcomer) throws SQLException {


        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate)) {


            preparedStatement.setString(1, employeeNewcomer.getFirstName());
            preparedStatement.setString(2, employeeNewcomer.getLastName());
            preparedStatement.setInt(3, employeeNewcomer.getYears_old());
            preparedStatement.setLong(4, employeeNewcomer.getId());

            preparedStatement.executeUpdate();

            logger.info("updating complete  " + getAll());

            //     closeConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(long id) throws SQLException {

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete)) {

            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

            logger.info("Deleting Complete  " + getAll());

            //    closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}