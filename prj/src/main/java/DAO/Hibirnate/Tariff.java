package DAO.Hibirnate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Tariffs_have_TariffOption",
            joinColumns = {@JoinColumn(name = "Tariffs_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "TariffOption_id", referencedColumnName = "id")})
    private Set<TariffOption> tariffOption = new HashSet();

    public Set<TariffOption> getTariffOption() {
        return tariffOption;
    }

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
