package test;

import javax.persistence.*;

/**
 * Created by Artyom Karnov on 8/21/16.
 * artyom-karnov@yandex.ru
 **/
@Entity
@Table(name = "Tariff_has_Option", schema = "test", catalog = "")
@IdClass(TariffHasOptionPK.class)
public class TariffHasOption {
    private int tariffId;
    private int optionId;

    @Id
    @Column(name = "Tariff_id")
    public int getTariffId() {
        return tariffId;
    }

    public void setTariffId(int tariffId) {
        this.tariffId = tariffId;
    }

    @Id
    @Column(name = "Option_id")
    public int getOptionId() {
        return optionId;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TariffHasOption that = (TariffHasOption) o;

        if (tariffId != that.tariffId) return false;
        if (optionId != that.optionId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tariffId;
        result = 31 * result + optionId;
        return result;
    }
}
