package DAO.Hibirnate;

import javax.persistence.*;

/**
 * Created by Artyom Karnov on 8/17/16.
 * artyom-karnov@yandex.ru
 **/
@Entity
@Table(name = "Tariffs_have_TariffOption")
public class Tariff_has_TariffOption {

    @Column(name = "TariffOption_id")
    private long TariffOption_id;

    @Column(name = "Tariffs_id")
    private long Tariffs_id;

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
}
