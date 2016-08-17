package DAO.Hibirnate;

import javax.persistence.*;

/**
 * Created by Artyom Karnov on 8/17/16.
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

    @Override
    public String toString() {
        return id + " " + title;
    }

    public String getTitle() {
        return title;
    }

    public long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
