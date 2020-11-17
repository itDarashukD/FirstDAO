package ProjectEmployeeInArmy.Service;

import ProjectEmployeeInArmy.Connect.Connect;
import ProjectEmployeeInArmy.DAO.Entity_DAO;
import ProjectEmployeeInArmy.Repository.Employee_Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Employee_Data_Service extends Connect implements Entity_DAO<Employee_Data> {

    private Connection connection = getConnection();


    @Override
    public void add(Employee_Data employee_data) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO employee_data (id, yearsold, education, citylive) VALUES(?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, employee_data.getId());
            preparedStatement.setLong(2, employee_data.getYearsold());
            preparedStatement.setString(3, employee_data.getEducation());
            preparedStatement.setString(4, employee_data.getCityLive());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }

    @Override
    public List<Employee_Data> getAll() throws SQLException {

        List<Employee_Data> list = new ArrayList<>();

        String sql = "SELECT * FROM employee_data";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Employee_Data employee_data = new Employee_Data();

                employee_data.setId(resultSet.getLong(3));
                employee_data.setYearsold(resultSet.getInt(4));

                employee_data.setEducation(resultSet.getString("education"));
                employee_data.setCityLive(resultSet.getString("cityLive"));


                list.add(employee_data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return list;
    }

    @Override
    public Employee_Data getById(long id) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM employee_data WHERE id=?";

        Employee_Data employee_data = new Employee_Data();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                employee_data.setId(resultSet.getLong("id"));
                employee_data.setYearsold((int) resultSet.getLong("yearsOld"));

                employee_data.setEducation(resultSet.getString("education"));
                employee_data.setCityLive(resultSet.getString("cityLive"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return employee_data;
    }


    @Override
    public void update(Employee_Data employee_data) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "UPDATE employee_data SET  yearsOld=?, education=?, cityLive=? WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, employee_data.getYearsold());
            preparedStatement.setString(2, employee_data.getEducation());
            preparedStatement.setString(3, employee_data.getCityLive());
            preparedStatement.setLong(4, employee_data.getId());

            preparedStatement.executeUpdate();
            System.out.println("updating Complete  " + getAll());

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public void delete(long id) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM employee_data WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();

            System.out.println("Deleting Complete  " + getAll());

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }
}

