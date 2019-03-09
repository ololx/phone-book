package phones.service;

import phones.entities.Book;
import phones.entities.DbEntity;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {

    List<Book> findByFio(String fio) throws SQLException ;

    public List<Book> findByPhone(String phone) throws SQLException;
}
