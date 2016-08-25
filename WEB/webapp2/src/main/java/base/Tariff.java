package base;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Artyom Karnov on 8/21/16.
 * artyom-karnov@yandex.ru
 **/
@Entity
public class Tariff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "title")
    private String title;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "AvailableTariffOption",
            joinColumns = @JoinColumn(name = "Tariff_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "TariffOption_id", referencedColumnName = "id"))
    private Set<TariffOption> tariffOptions;

    public Set<TariffOption> getTariffOptions() {
        return tariffOptions;
    }

    public void setTariffOptions(Set<TariffOption> tariffOptions) {
        this.tariffOptions = tariffOptions;
    }

    public Tariff() {
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

    public Tariff(String title) {
        this.title = title;
    }

    public Tariff(int id, String title) {
        this.id = id;
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tariff tariff = (Tariff) o;

        if (id != tariff.id) return false;
        if (title != null ? !title.equals(tariff.title) : tariff.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tariff{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
