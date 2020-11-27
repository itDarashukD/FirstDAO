package projectEmployeeInArmy.repository;

import projectEmployeeInArmy.repository.api.Idao;
import projectEmployeeInArmy.repository.connection.DataBaseConnection;
import projectEmployeeInArmy.repository.model.EmployeeArmy;
import projectEmployeeInArmy.resources.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmployeeArmyRepository implements Idao<EmployeeArmy> {

    private final DataBaseConnection dataBaseConnection = DataBaseConnection.getInstance();

    private final Connection connection = dataBaseConnection.getConnection();

    Constants constants = new Constants();


    @Override
    public void add(EmployeeArmy employeeArmy) {

        try (PreparedStatement preparedStatement = connection.prepareStatement(constants.getSQL_ADD_EMPLOYEE_ARMY())) {

            preparedStatement.setString(1, employeeArmy.getPositions());
            preparedStatement.setString(2, employeeArmy.getFirstName());
            preparedStatement.setLong(3, employeeArmy.getId());
            preparedStatement.setString(4, employeeArmy.getRank());
            preparedStatement.setString(5, employeeArmy.getLastName());
            preparedStatement.setInt(6, employeeArmy.getYear_in_army());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    @Override
    public List<EmployeeArmy> getAll() {
        List<EmployeeArmy> list = new ArrayList<>();


        try (Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(constants.getSQL_GET_ALL_EMPLOYEE_ARMY());

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

        } catch (SQLException e) {
            e.printStackTrace();


        }
        return list;
    }


    @Override
    public EmployeeArmy getById(long id) {

        EmployeeArmy employeeArmy = new EmployeeArmy();

        try (PreparedStatement preparedStatement = connection.prepareStatement(constants.getSQL_GET_BY_ID_EMPLOYEE_ARMY())) {
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

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return employeeArmy;


    }

    @Override
    public void update(EmployeeArmy employeeArmy) {

        try (PreparedStatement preparedStatement = connection.prepareStatement(constants.getSQL_UPDATE_EMPLOYEE_ARMY())) {

            preparedStatement.setString(1, employeeArmy.getPositions());
            preparedStatement.setString(2, employeeArmy.getFirstName());
            preparedStatement.setString(3, employeeArmy.getRank());
            preparedStatement.setString(4, employeeArmy.getLastName());
            preparedStatement.setInt(5, employeeArmy.getYear_in_army());
            preparedStatement.setLong(6, employeeArmy.getId());

            preparedStatement.executeUpdate();
            System.out.println("updating Complete  " + getAll());

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void delete(long id) {

        try (PreparedStatement preparedStatement = connection.prepareStatement(constants.getSQL_DELETE_EMPLOYEE_ARMY())) {

            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

            System.out.println("Deleting Complete  " + getAll());


        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}