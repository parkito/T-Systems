package test;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Artyom Karnov on 8/21/16.
 * artyom-karnov@yandex.ru
 **/
@Entity
@Table(name = "Tariff", schema = "test", catalog = "")
public class TariffEntity {
    private int id;
    private String title;
    private Set<TariffOptionEntity> tariffOptions;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Tariff_has_Option",
            joinColumns = @JoinColumn(name = "Tariff_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "Option_id", referencedColumnName = "id"))
    public Set<TariffOptionEntity> getTariffOptions() {
        return tariffOptions;
    }

    public void setTariffOptions(Set<TariffOptionEntity> tariffOptions) {
        this.tariffOptions = tariffOptions;
    }


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TariffEntity that = (TariffEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

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
        return "TariffEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
