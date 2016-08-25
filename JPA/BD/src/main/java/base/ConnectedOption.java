package base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/
@Entity
public class ConnectedOption {
    private int tariffOptionId;

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

        ConnectedOption that = (ConnectedOption) o;

        if (tariffOptionId != that.tariffOptionId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return tariffOptionId;
    }
}
