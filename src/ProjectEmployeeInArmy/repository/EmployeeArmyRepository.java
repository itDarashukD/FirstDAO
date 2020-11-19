package ProjectEmployeeInArmy.repository;

import ProjectEmployeeInArmy.repository.connection.ConnectionDataBase;
import ProjectEmployeeInArmy.repository.api.Idao;
import ProjectEmployeeInArmy.repository.model.EmployeeArmy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmployeeArmyRepository extends ConnectionDataBase implements Idao<EmployeeArmy> {

    private Connection connection = getConnection();

    String sqlAdd = "INSERT INTO employee_army ( positions,firstname,id,rank,lastname,year_in_army) VALUES (?,?,?,?,?,?)";
    String sqlGetAll = "SELECT * FROM employee_army";
    String sqlGetById = "SELECT * FROM employee_army WHERE id=?";
    String sqlUpdate = "UPDATE employee_army SET positions=?,firstName=?,rank=?,lastName=?,year_in_army=? WHERE id=?";
    String sqlDelete = "DELETE FROM employee_army WHERE id=?";

    @Override
    public void add(EmployeeArmy employeeArmy) throws SQLException {

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlAdd)) {

            preparedStatement.setString(1, employeeArmy.getPositions());
            preparedStatement.setString(2, employeeArmy.getFirstName());
            preparedStatement.setLong(3, employeeArmy.getId());
            preparedStatement.setString(4, employeeArmy.getRank());
            preparedStatement.setString(5, employeeArmy.getLastName());
            preparedStatement.setInt(6, employeeArmy.getYear_in_army());

            preparedStatement.executeUpdate();
            closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    @Override
    public List<EmployeeArmy> getAll() throws SQLException {
        List<EmployeeArmy> list = new ArrayList<>();



        try (Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sqlGetAll);

            while (resultSet.next()) {
                EmployeeArmy employeeArmy = new EmployeeArmy();
                employeeArmy.setPositions(resultSet.getString(1));
                employeeArmy.setFirstName(resultSet.getString(2));
                employeeArmy.setId(resultSet.getLong(3));
                employeeArmy.setRank(resultSet.getString(4));
                employeeArmy.setLastName(resultSet.getString(5));
                employeeArmy.setYear_in_army(resultSet.getInt(6));

                list.add(employeeArmy);
            }
            closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();


        }
        return list;
    }


    @Override
    public EmployeeArmy getById(long id) throws SQLException {

        EmployeeArmy employeeArmy = new EmployeeArmy();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlGetById)) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                employeeArmy.setPositions(resultSet.getString(1));
                employeeArmy.setFirstName(resultSet.getString(2));
                employeeArmy.setId(resultSet.getLong(3));
                employeeArmy.setRank(resultSet.getString(4));
                employeeArmy.setLastName(resultSet.getString(5));
                employeeArmy.setYear_in_army(resultSet.getInt(6));
            }
            closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return employeeArmy;


    }

    @Override
    public void update(EmployeeArmy employeeArmy) throws SQLException {

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate)) {

            preparedStatement.setString(1, employeeArmy.getPositions());
            preparedStatement.setString(2, employeeArmy.getFirstName());
            preparedStatement.setString(3, employeeArmy.getRank());
            preparedStatement.setString(4, employeeArmy.getLastName());
            preparedStatement.setInt(5, employeeArmy.getYear_in_army());
            preparedStatement.setLong(6, employeeArmy.getId());

            preparedStatement.executeUpdate();
            System.out.println("updating Complete  " + getAll());
            closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void delete(long id) throws SQLException {

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete)) {

            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

            System.out.println("Deleting Complete  " + getAll());

            closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}