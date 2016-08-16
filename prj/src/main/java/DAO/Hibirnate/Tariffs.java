package DAO.Hibirnate;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Artyom Karnov on 8/16/16.
 * artyom-karnov@yandex.ru
 **/
@Entity
@Table(name = "Tariffs")
public class Tariff {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private long id;
    @Column(name = "title")
    private String title;

    public Tariff() {
    }

    public Tariff(String title) {
        this.title = title;
    }

}
