package phones.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import phones.entities.Book;
import phones.entities.DbEntity;
import phones.utils.HibernateSessionFactoryUtil;
import java.sql.SQLException;
import java.util.List;

public class BookDaoImpl implements EntityDao<Book>, BookDao {

    @Override
    public List<Book> findAll() throws SQLException {
        Session mSession = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Book> mBooks = mSession.createQuery("From Book").list();
        mSession.close();
        return mBooks;
    }

    @Override
    public void save(Book book) throws SQLException {
        Session mSession = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction mTransaction = mSession.beginTransaction();
        mSession.save(book);
        mTransaction.commit();
        mSession.close();
    }

    @Override
    public void update(Book book) throws SQLException {
        Session mSession = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction mTransaction = mSession.beginTransaction();
        mSession.update(book);
        mTransaction.commit();
        mSession.close();
    }

    @Override
    public void delete(Book book) throws SQLException {
        Session mSession = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction mTransaction = mSession.beginTransaction();
        mSession.delete(book);
        mTransaction.commit();
        mSession.close();
    }

    @Override
    public Book findById(int id) throws SQLException {
        Session mSession = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Book mBook = mSession.get(Book.class, id);
        mSession.close();
        return mBook;
    }

    @Override
    public List<Book> findByFio(String fio) throws SQLException {
        Session mSession = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query mQuery = mSession.createQuery("From Book Where lower(fio) Like CONCAT('%', :fio, '%')");
        mQuery.setParameter("fio", fio.toLowerCase());
        List<Book> mBooks = mQuery.getResultList();
        mSession.close();
        return mBooks;
    }

    @Override
    public List<Book> findByPhone(String phone) throws SQLException {
        Session mSession = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query mQuery = mSession.createQuery("From Book Where phone = :phone");
        mQuery.setParameter("phone", phone.toLowerCase());
        List<Book> mBooks = mQuery.getResultList();
        mSession.close();
        return mBooks;
    }
}
