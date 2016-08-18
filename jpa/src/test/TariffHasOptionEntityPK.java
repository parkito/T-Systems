package test;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Artyom Karnov on 8/19/16.
 * artyom-karnov@yandex.ru
 **/
public class TariffHasOptionEntityPK implements Serializable {
    private int tariffId;
    private int optionId;

    @Column(name = "Tariff_id")
    @Id
    public int getTariffId() {
        return tariffId;
    }

    public void setTariffId(int tariffId) {
        this.tariffId = tariffId;
    }

    @Column(name = "Option_id")
    @Id
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

        TariffHasOptionEntityPK that = (TariffHasOptionEntityPK) o;

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
