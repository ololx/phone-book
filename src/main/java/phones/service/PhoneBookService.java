package phones.service;

import phones.entities.Book;

import java.sql.SQLException;
import java.util.List;

public class PhoneBookService {

    private BookDaoImpl mBookManager = new BookDaoImpl();

    public Book createRecord(String fio, String phone) throws SQLException {
        Book mBook = new Book(fio, phone);
        this.mBookManager.save(mBook);
        return mBook;
    }

    public Book updateRecord(int id, String fio, String phone) throws SQLException {
        Book mBook = this.mBookManager.findById(id);

        if(fio != null) {
            mBook.setFio(fio);
        }

        if(phone != null) {
            mBook.setPhone(phone);
        }

        this.mBookManager.update(mBook);
        return mBook;
    }

    public Book deleteRecord(int id) throws SQLException {
        Book mBook = this.mBookManager.findById(id);
        this.mBookManager.delete(mBook);
        return mBook;
    }

    public List<Book> getAllRecords() throws SQLException {
        List<Book> mBooks = this.mBookManager.findAll();
        return mBooks;
    }

    public List<Book> getFioRecords(String fio) throws SQLException {
        List<Book> mBooks = this.mBookManager.findByFio(fio);
        return mBooks;
    }

    public List<Book> getPhoneRecords(String phone) throws SQLException {
        List<Book> mBooks = this.mBookManager.findByPhone(phone);
        return mBooks;
    }
}
