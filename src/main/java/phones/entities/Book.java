package phones.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author kropotin
 */
@Entity
@Table(name = "public.BOOK")
public class Book implements Serializable, DbEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,
                    generator="book_id_gen")
    @SequenceGenerator(name="book_id_gen",
                       sequenceName="public.book_id_seq", allocationSize=1000)
    @Column (name = "ID", unique=true, nullable=false)
    private Integer id;
    
    @Column (name = "FIO", unique=false, nullable=false)
    private String fio;
    
    @Column (name = "PHONE", unique=false, nullable=false)
    private String phone;
    
    public Book() {

    }

    public Book(String fio, String phone) {
        this.setFio(fio);
        this.setPhone(phone);

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getFio() {
        return this.fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }
    
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("Book_%1$s = {id = %1$s, name = %2$s, phone = %3$s}",
                this.id, this.fio, this.phone);
    }
}
