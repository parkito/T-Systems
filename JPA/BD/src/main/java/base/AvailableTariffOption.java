package base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * Created by Artyom Karnov on 8/21/16.
 * artyom-karnov@yandex.ru
 **/
@Entity
@IdClass(AvailableTariffOptionPK.class)
public class AvailableTariffOption {
    private int tariffId;
    private int tariffOptionId;

    @Id
    @Column(name = "Tariff_id")
    public int getTariffId() {
        return tariffId;
    }

    public void setTariffId(int tariffId) {
        this.tariffId = tariffId;
    }

    @Id
    @Column(name = "TariffOption_id")
    public int getTariffOptionId() {
        return tariffOptionId;
    }

    public void setTariffOptionId(int tariffOptionId) {
        this.tariffOptionId = tariffOptionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AvailableTariffOption that = (AvailableTariffOption) o;

        if (tariffId != that.tariffId) return false;
        if (tariffOptionId != that.tariffOptionId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tariffId;
        result = 31 * result + tariffOptionId;
        return result;
    }
}
