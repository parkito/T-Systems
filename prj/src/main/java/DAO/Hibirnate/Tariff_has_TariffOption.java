package DAO.Hibirnate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Artyom Karnov on 8/17/16.
 * artyom-karnov@yandex.ru
 **/
@Entity
@Table(name = "Tariffs_have_TariffOption")
public class Tariff_has_TariffOption {
    @Id
    @Column(name = "TariffOption_id")
    private long TariffOption_id;

    @Column(name = "Tariffs_id")
    private long Tariffs_id;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "Tariffs",
            joinColumns = {@JoinColumn(name = "id",referencedColumnName = "Tariffs_id")},
            inverseJoinColumns = {@JoinColumn(name = "id")})
    private Set<Tariff> tariffs = new HashSet<Tariff>();

    @OneToMany(cascade = {CascadeType.ALL})
    private Set<TariffOption> tariffOptions = new HashSet<TariffOption>();

    public Tariff_has_TariffOption() {
    }

    public Tariff_has_TariffOption(long TariffOption_id, long Tariffs_id) {
        this.TariffOption_id = TariffOption_id;
        this.Tariffs_id = Tariffs_id;
    }

    public long getTariffOption_id() {
        return TariffOption_id;
    }

    public long getTariffs_id() {
        return Tariffs_id;
    }

    public void setTariffOption_id(long tariffOption_id) {
        TariffOption_id = tariffOption_id;
    }

    public void setTariffs_id(long tariffs_id) {
        Tariffs_id = tariffs_id;
    }

    public Set<Tariff> getTariffs() {
        return tariffs;
    }

    public Set<TariffOption> getTariffOptions() {
        return tariffOptions;
    }
}
