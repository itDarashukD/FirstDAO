package ProjectEmployeeInArmy.Service;

import ProjectEmployeeInArmy.Connect.Connect;
import ProjectEmployeeInArmy.DAO.Entity_DAO;
import ProjectEmployeeInArmy.Repository.Newcomer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Newcomer_Service extends Connect implements Entity_DAO<Newcomer> {

    private final Connection connection = getConnection();

    @Override
    public void add(Newcomer newcomer) throws SQLException {


        String sql = "INSERT INTO newcomer ( id,first_name,last_name,years_old) VALUES (?,?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {


            preparedStatement.setLong(1, newcomer.getId());
            preparedStatement.setString(2, newcomer.getFirst_name());
            preparedStatement.setString(3, newcomer.getLast_name());
            preparedStatement.setLong(4, newcomer.getYears_old());

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
    public List<Newcomer> getAll() throws SQLException {
        List<Newcomer> list = new ArrayList<>();

        String sql = "SELECT * FROM newcomer";

        try (Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Newcomer newcomer1 = new Newcomer();
                newcomer1.setId(resultSet.getLong(1));
                newcomer1.setFirst_name(resultSet.getString(2));
                newcomer1.setLast_name(resultSet.getString(3));
                newcomer1.setYears_old(resultSet.getInt(4));

                list.add(newcomer1);

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
    public Newcomer getById(long id) throws SQLException {
        Newcomer newcomer = new Newcomer();

        String sql = "SELECT * FROM newcomer WHERE id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                newcomer.setId(resultSet.getLong(1));
                newcomer.setFirst_name(resultSet.getString(2));
                newcomer.setLast_name(resultSet.getString(3));
                newcomer.setYears_old(resultSet.getInt(4));

            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            if (connection != null) {
                connection.close();
            }

        }
        return newcomer;


    }


    @Override
    public void update(Newcomer newcomer) throws SQLException {
        String sql = "UPDATE newcomer SET first_name=?,last_name=?,years_old=? WHERE id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {


            preparedStatement.setString(1, newcomer.getFirst_name());
            preparedStatement.setString(2, newcomer.getLast_name());
            preparedStatement.setInt(3, newcomer.getYears_old());
            preparedStatement.setLong(4, newcomer.getId());

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

        String sql = "DELETE FROM newcomer WHERE id=?";

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