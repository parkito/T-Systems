package my;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Artyom Karnov on 8/19/16.
 * artyom-karnov@yandex.ru
 **/
@Entity
@Table(name = "NumberStatus", schema = "operator", catalog = "")
public class NumberStatusEntity {
    private String number;

    @Id
    @Column(name = "number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NumberStatusEntity that = (NumberStatusEntity) o;

        if (number != null ? !number.equals(that.number) : that.number != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return number != null ? number.hashCode() : 0;
    }
}
