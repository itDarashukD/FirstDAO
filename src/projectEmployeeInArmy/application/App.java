package projectEmployeeInArmy.application;

import projectEmployeeInArmy.repository.EmployeeDataRepository;
import projectEmployeeInArmy.repository.connection.DataBaseConnection;
import projectEmployeeInArmy.repository.model.EmployeeData;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class App {
    private static Logger logger = Logger.getLogger(App.class.getName());


    public static void main(String[] args) throws SQLException, IOException {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        DataBaseConnection.getInstance();

        EmployeeDataRepository employeeDataRepository = new EmployeeDataRepository();
        //  EmployeeArmyRepository employeeArmyRepository = new EmployeeArmyRepository();
        //  NewcomerRepository newcomerRepository = new NewcomerRepository();

        EmployeeData employeeData = new EmployeeData();
        employeeData.setCityLive("Brest");
        employeeData.setEducation("lowlest");
        employeeData.setYearsOld(85);
        employeeData.setId(3);

        //вызываем метод добавления записей передавая заполненный объект

        //  employeeDataRepository.add(employeeData);

        //вызываем метод чтения всего

        List<EmployeeData> list = employeeDataRepository.getAll();
        for (EmployeeData var : list
        ) {
            logger.info(var.toString());
        }
        //вызываем метод чтения по id

        logger.info(employeeDataRepository.getById(1L).toString());

        //вызываем метод обновления данных

        //  employeeDataRepository.update(employee_data);

        //вызываем метод удаления данных

        //  employeeDataRepository.delete(2L);

        DataBaseConnection.closeConnection(dataBaseConnection.getConnection());

    }
}
