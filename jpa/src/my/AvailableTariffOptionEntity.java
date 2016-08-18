package my;

import javax.persistence.*;

/**
 * Created by Artyom Karnov on 8/19/16.
 * artyom-karnov@yandex.ru
 **/
@Entity
@Table(name = "AvailableTariffOption", schema = "operator", catalog = "")
@IdClass(AvailableTariffOptionEntityPK.class)
public class AvailableTariffOptionEntity {
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

        AvailableTariffOptionEntity that = (AvailableTariffOptionEntity) o;

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
