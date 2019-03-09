package phones.service;

import phones.entities.Book;
import phones.entities.DbEntity;

import java.sql.SQLException;
import java.util.List;

public interface EntityDao<ENTITY extends DbEntity> {

    ENTITY findById(int id) throws SQLException ;

    List<ENTITY> findAll() throws SQLException ;

    void save(ENTITY book) throws SQLException ;

    void update(ENTITY book) throws SQLException ;

    void delete(ENTITY book) throws SQLException ;
}
