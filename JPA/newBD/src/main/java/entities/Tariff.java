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
    private int tariffId;
    private String title;
    private Double price;

    @Id
    @Column(name = "tariff_id")
    public int getTariffId() {
        return tariffId;
    }

    public void setTariffId(int tariffId) {
        this.tariffId = tariffId;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "price")
    public Double getPrice() {
        return price;
    }


    public void setPrice(Double price) {
        this.price = price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tariff tariff = (Tariff) o;

        if (tariffId != tariff.tariffId) return false;
        if (title != null ? !title.equals(tariff.title) : tariff.title != null) return false;
        if (price != null ? !price.equals(tariff.price) : tariff.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tariffId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
