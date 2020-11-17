package ProjectEmployeeInArmy.Service;

import ProjectEmployeeInArmy.Connect.Connect;
import ProjectEmployeeInArmy.DAO.Entity_DAO;
import ProjectEmployeeInArmy.Repository.Employee_Army;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Employee_Army_Service extends Connect implements Entity_DAO<Employee_Army> {

    private Connection connection = getConnection();

    @Override
    public void add(Employee_Army employee_army) throws SQLException {


        String sql = "INSERT INTO employee_army ( positions,firstname,id,rank,lastname,year_in_army) VALUES (?,?,?,?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {


            preparedStatement.setString(1, employee_army.getPositions());
            preparedStatement.setString(2, employee_army.getFirstname());
            preparedStatement.setLong(3, employee_army.getId());
            preparedStatement.setString(4, employee_army.getRank());
            preparedStatement.setString(5, employee_army.getLastname());
            preparedStatement.setInt(6, employee_army.getYear_in_army());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public List<Employee_Army> getAll() throws SQLException {
        List<Employee_Army> list = new ArrayList<>();

        String sql = "SELECT * FROM employee_army";

        try (Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Employee_Army employee_army = new Employee_Army();
                employee_army.setPositions(resultSet.getString(1));
                employee_army.setFirstname(resultSet.getString(2));
                employee_army.setId(resultSet.getLong(3));
                employee_army.setRank(resultSet.getString(4));
                employee_army.setLastname(resultSet.getString(5));
                employee_army.setYear_in_army(resultSet.getInt(6));

                list.add(employee_army);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            if (connection != null) {
                connection.close();
            }

        }
        return list;
    }


    @Override
    public Employee_Army getById(long id) throws SQLException {

        Employee_Army employee_army = new Employee_Army();
        String sql = "SELECT * FROM employee_army WHERE id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                employee_army.setPositions(resultSet.getString(1));
                employee_army.setFirstname(resultSet.getString(2));
                employee_army.setId(resultSet.getLong(3));
                employee_army.setRank(resultSet.getString(4));
                employee_army.setLastname(resultSet.getString(5));
                employee_army.setYear_in_army(resultSet.getInt(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            if (connection != null) {
                connection.close();
            }

        }
        return employee_army;


    }

    @Override
    public void update(Employee_Army employee_army) throws SQLException {
        String sql = "UPDATE employee_army SET positions=?,firstName=?,rank=?,lastName=?,year_in_army=? WHERE id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, employee_army.getPositions());
            preparedStatement.setString(2, employee_army.getFirstname());
            preparedStatement.setString(3, employee_army.getRank());
            preparedStatement.setString(4, employee_army.getLastname());
            preparedStatement.setInt(5, employee_army.getYear_in_army());
            preparedStatement.setLong(6, employee_army.getId());

            preparedStatement.executeUpdate();
            System.out.println("updating Complete  " + getAll());

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public void delete(long id) throws SQLException {

        String sql = "DELETE FROM employee_army WHERE id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

            System.out.println("Deleting Complete  " + getAll());

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (connection != null) {
                connection.close();
            }


        }
    }
}