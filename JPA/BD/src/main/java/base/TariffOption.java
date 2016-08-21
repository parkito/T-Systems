package base;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Artyom Karnov on 8/21/16.
 * artyom-karnov@yandex.ru
 **/
@Entity
public class TariffOption {
    private int id;
    private String title;
    private double price;
    private Double connectionPrice;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "connectionPrice")
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
}
