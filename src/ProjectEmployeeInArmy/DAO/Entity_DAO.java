package ProjectEmployeeInArmy.DAO;

import java.sql.SQLException;
import java.util.List;

public interface Entity_DAO<T> {
    // добавление
    void add(T entity) throws SQLException;

    //получение всего списка
    List<T> getAll() throws SQLException;

    //получение по id
    T getById(long id) throws SQLException;

    //обновление
    void update(T entity) throws SQLException;

    //удаление по id
    void delete(long id) throws SQLException;


}
