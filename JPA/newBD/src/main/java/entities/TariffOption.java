package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Contract> getContracts() {
        return contracts;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "tariffOptions")
    private final List<Contract> contracts = new ArrayList();


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

    @Override
    public String toString() {
        return "TariffOption{" +
                "tariffOptionId=" + tariffOptionId +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", connectionPrice=" + connectionPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TariffOption that = (TariffOption) o;

        if (tariffOptionId != that.tariffOptionId) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (connectionPrice != null ? !connectionPrice.equals(that.connectionPrice) : that.connectionPrice != null)
            return false;
        if (contracts != null ? !contracts.equals(that.contracts) : that.contracts != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = tariffOptionId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (connectionPrice != null ? connectionPrice.hashCode() : 0);
        result = 31 * result + (contracts != null ? contracts.hashCode() : 0);
        return result;
    }
}
