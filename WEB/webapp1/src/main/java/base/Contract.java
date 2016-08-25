package base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Artyom Karnov on 8/21/16.
 * artyom-karnov@yandex.ru
 **/
@Entity
public class Contract {
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

        Contract contract = (Contract) o;

        if (number != null ? !number.equals(contract.number) : contract.number != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return number != null ? number.hashCode() : 0;
    }
}
