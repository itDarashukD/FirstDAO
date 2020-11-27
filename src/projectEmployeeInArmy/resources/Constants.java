package projectEmployeeInArmy.resources;

import lombok.*;
import projectEmployeeInArmy.repository.model.EmployeeArmy;


@Getter
public class Constants {

    private final String SQL_ADD_EMPLOYEE_ARMY = "INSERT INTO employee_army ( positions,firstname,id,rank,lastname,year_in_army) VALUES (?,?,?,?,?,?)";
    private final String SQL_GET_ALL_EMPLOYEE_ARMY = "SELECT * FROM employee_army";
    private final String SQL_GET_BY_ID_EMPLOYEE_ARMY = "SELECT * FROM employee_army WHERE id=?";
    private final String SQL_UPDATE_EMPLOYEE_ARMY = "UPDATE employee_army SET positions=?,firstName=?,rank=?,lastName=?,year_in_army=? WHERE id=?";
    private final String SQL_DELETE_EMPLOYEE_ARMY = "DELETE FROM employee_army WHERE id=?";


    private final String SQL_ADD_EMPLOYEE_DATA = "INSERT INTO employee_data (id, yearsold, education, citylive) VALUES(?, ?, ?, ?)";
    private final String SQL_GET_ALL_EMPLOYEE_DATA = "SELECT * FROM employee_data";
    private final String SQL_GET_BY_ID_EMPLOYEE_DATA = "SELECT * FROM employee_data WHERE id=?";
    private final String SQL_UPDATE_EMPLOYEE_DATA = "UPDATE employee_data SET  yearsOld=?, education=?, cityLive=? WHERE id=?";
    private final String SQL_DELETE_EMPLOYEE_DATA = "DELETE FROM employee_data WHERE id=?";

    private final String SQL_ADD_NEWCOMER = "INSERT INTO newcomer ( id,first_name,last_name,years_old) VALUES (?,?,?,?)";
    private final String SQL_GET_ALL_NEWCOMER = "SELECT * FROM newcomer";
    private final String SQL_GET_BY_ID_NEWCOMER = "SELECT * FROM newcomer WHERE id=?";
    private final String SQL_UPDATE_NEWCOMER = "UPDATE newcomer SET first_name=?,last_name=?,years_old=? WHERE id=?";
    private final String SQL_DELETE_NEWCOMER = "DELETE FROM newcomer WHERE id=?";
}
