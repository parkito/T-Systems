package entities;

import javax.persistence.*;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/
@Entity
@Table(name = "TariffOption")
@NamedQuery(name = "TariffOption.getAll", query = "SELECT opt FROM TariffOption opt")
public class TariffOption {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tariffOption_id")
    private int tariffOptionId;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "price")
    private double price;
    @Basic
    @Column(name = "connectionPrice")
    private Double connectionPrice;


    public int getTariffOptionId() {
        return tariffOptionId;
    }

    public void setTariffOptionId(int tariffOptionId) {
        this.tariffOptionId = tariffOptionId;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public Double getConnectionPrice() {
        return connectionPrice;
    }

    public void setConnectionPrice(Double connectionPrice) {
        this.connectionPrice = connectionPrice;
    }

    public TariffOption(String title, double price, Double connectionPrice) {
        this.title = title;
        this.price = price;
        this.connectionPrice = connectionPrice;
    }

    public TariffOption() {
    }
}
