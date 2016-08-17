package DAO.Hibirnate;

import com.sun.istack.internal.Nullable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    @Nullable
    @Column(name = "connectionPrice")
    private Double connectionPrice;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Tariffs_have_TariffOption",
            joinColumns = {@JoinColumn(name = "TariffOption_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "Tariffs_id", referencedColumnName = "id")})
    private Set<Tariff> tariff = new HashSet();

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

    public void setConnectionPrice(Double connectionPrice) {
        if (connectionPrice == null)
            connectionPrice = -1.0;
        else
            this.connectionPrice = connectionPrice;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Tariff> getTariff() {
        return tariff;
    }
}
