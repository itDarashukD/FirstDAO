package ProjectEmployeeInArmy.application;

import ProjectEmployeeInArmy.repository.EmployeeDataRepository;
import ProjectEmployeeInArmy.repository.model.EmployeeData;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class App {
    private static Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) throws SQLException {
        EmployeeDataRepository employeeDataRepository = new EmployeeDataRepository();
        //  EmployeeArmyRepository employeeArmyRepository = new EmployeeArmyRepository();
        // NewcomerRepository newcomerRepository = new NewcomerRepository();

        EmployeeData employeeData = new EmployeeData();
        employeeData.setCityLive("Brest");
        employeeData.setEducation("lowlest");
        employeeData.setYearsOld(85);
        employeeData.setId(3);

        //вызываем метод добавления записей передавая заполненный объект

        //  employeeDataRepository.add(employee_data);

        //вызываем метод чтения всего

        List<EmployeeData> list = employeeDataRepository.getAll();
        for (EmployeeData var : list
        ) {
            logger.info(var.toString());
        }
        //вызываем метод чтения по id

        //   logger.info(employeeDataRepository.getById(1L).toString());

        //вызываем метод обновления данных

        //  employeeDataRepository.update(employee_data);

        //вызываем метод удаления данных

        //  employeeDataRepository.delete(2L);

    }
}
