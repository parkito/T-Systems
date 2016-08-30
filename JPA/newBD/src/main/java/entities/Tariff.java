package entities;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/
@Entity
@Table(name = "Tariff")
@NamedQuery(name = "Tariff.getAll", query = "SELECT tar FROM Tariff tar")
public class Tariff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tariff_id")
    private int tariffId;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "price")
    private Double price;
    @Basic
    @Column(name = "connectionPrice")
    private Double connectionPrice;

    public int getTariffId() {
        return tariffId;
    }

    public void setTariffId(int tariffId) {
        this.tariffId = tariffId;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Double getPrice() {
        return price;
    }


    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getConnectionPrice() {
        return connectionPrice;
    }

    public void setConnectionPrice(Double connectionPrice) {
        this.connectionPrice = connectionPrice;
    }

    public Tariff(String title, Double price, Double connectionPrice) {
        this.title = title;
        this.price = price;
        this.connectionPrice = connectionPrice;
    }

    public Tariff() {
    }
}
