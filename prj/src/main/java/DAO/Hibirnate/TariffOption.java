package DAO.Hibirnate;

import javax.persistence.*;

/**
 * Created by Artyom Karnov on 8/16/16.
 * artyom-karnov@yandex.ru
 **/
@Entity
@Table(name = "TariffOption")
public class TariffOption {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private double price;

    @Column(name = "connectionPrice")
    private double connectionPrice;

    public TariffOption() {
    }

    public TariffOption(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return id + " " + title + " " + price + " " + connectionPrice;
    }

    public String getTitle() {
        return title;
    }

    public long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public double getConnectionPrice() {
        return connectionPrice;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setConnectionPrice(double connectionPrice) {
        this.connectionPrice = connectionPrice;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
