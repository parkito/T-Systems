package my;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Artyom Karnov on 8/19/16.
 * artyom-karnov@yandex.ru
 **/
public class AvailableTariffOptionEntityPK implements Serializable {
    private int tariffId;
    private int tariffOptionId;

    @Column(name = "Tariff_id")
    @Id
    public int getTariffId() {
        return tariffId;
    }

    public void setTariffId(int tariffId) {
        this.tariffId = tariffId;
    }

    @Column(name = "TariffOption_id")
    @Id
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

        AvailableTariffOptionEntityPK that = (AvailableTariffOptionEntityPK) o;

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
