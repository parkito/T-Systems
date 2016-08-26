package base;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Artyom Karnov on 8/21/16.
 * artyom-karnov@yandex.ru
 **/
@Entity
public class TariffOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "title")
    private String title;

    @Basic
    @Column(name = "price")
    private double price;

    @Basic
    @Column(name = "connectionPrice")
    private Double connectionPrice;

    @ManyToMany(mappedBy = "tariffOptions")
    private Set<Tariff> tariff;


    public Set<Tariff> getTariff() {
        return tariff;
    }

    public void setTariff(Set<Tariff> options) {
        this.tariff = options;
    }


    public TariffOption(String title, double price, Double connectionPrice) {
        this.title = title;
        this.price = price;
        this.connectionPrice = connectionPrice;
    }

    public TariffOption() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TariffOption that = (TariffOption) o;

        if (id != that.id) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (connectionPrice != null ? !connectionPrice.equals(that.connectionPrice) : that.connectionPrice != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (connectionPrice != null ? connectionPrice.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TariffOption{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", connectionPrice=" + connectionPrice +
                '}';
    }
}
