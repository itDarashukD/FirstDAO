package ProjectEmployeeInArmy;

import ProjectEmployeeInArmy.Repository.Employee_Army;
import ProjectEmployeeInArmy.Repository.Employee_Data;
import ProjectEmployeeInArmy.Repository.Newcomer;
import ProjectEmployeeInArmy.Service.Employee_Army_Service;
import ProjectEmployeeInArmy.Service.Employee_Data_Service;
import ProjectEmployeeInArmy.Service.Newcomer_Service;

import java.sql.SQLException;

import java.util.List;

public class DoMain {
    public static void main(String[] args) throws SQLException {
      Employee_Data_Service employee_data_service = new Employee_Data_Service();
//          Employee_Army_Service employee_army_service = new Employee_Army_Service();
    Newcomer_Service newcomer_service = new Newcomer_Service();

        Employee_Data employee_data = new Employee_Data();
        employee_data.setCityLive("Brest");
        employee_data.setEducation("lowlest");
        employee_data.setYearsold(85);
        employee_data.setId(3);

        Employee_Army employee_army = new Employee_Army();
        employee_army.setPositions("dad ead a");
        employee_army.setYear_in_army(22);
        employee_army.setLastname("Shlemen");
        employee_army.setRank("major");
        employee_army.setFirstname("Alex");
        employee_army.setId(1L);


        Newcomer newcomer = new Newcomer();
        newcomer.setId(4L);
        newcomer.setFirst_name("redclif");
        newcomer.setLast_name("gerard");
        newcomer.setYears_old(33);

        //вызываем метод добавления записей передавая заполненный объект

        //   employee_data_service.add(employee_data);
        //_____________________________________________________________________
        //          employee_army_service.add(employee_army);
        //______________________________________________________________________
     //      newcomer_service.add(newcomer);

        //вызываем метод чтения всего

//        List<Employee_Data> list =  employee_data_service.getAll();
//        for (Employee_Data var:list
//             ) {
//            System.out.println(var.toString());
//
//        }
     // _________________________________________________________________
//        List<Employee_Army> list = employee_army_service.getAll();
//        for (Employee_Army var:list
//             ) {
//            System.out.println(var.toString());
//
//        }
   //   _____________________________________________________________________
        List<Newcomer> list = newcomer_service.getAll();
        for (Newcomer var : list
        ) {
            System.out.println(var.toString());

        }


        //вызываем метод чтения по id

  //           System.out.println(employee_data_service.getById(4L).toString());
//         ________________________________________________________________________
//               System.out.println(employee_army_service.getById(1L).toString());
//        _________________________________________________________________________
//          System.out.println(newcomer_service.getById(3));


        //вызываем метод обновления данных

        //       employee_data_service.update(employee_data);
        //__________________________________________________________________________
        //         employee_army_service.update(employee_army);
        //__________________________________________________________________________
        //    newcomer_service.update(newcomer);


        //вызываем метод удаления данных

   //     employee_data_service.delete(4L);
        //__________________________________________________________________
        //        employee_army_service.delete(2L);
        //__________________________________________________________________
       // newcomer_service.delete(3);
    }
}
