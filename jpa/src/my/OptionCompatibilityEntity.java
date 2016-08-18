package my;

import javax.persistence.*;

/**
 * Created by Artyom Karnov on 8/19/16.
 * artyom-karnov@yandex.ru
 **/
@Entity
@Table(name = "OptionCompatibility", schema = "operator", catalog = "")
@IdClass(OptionCompatibilityEntityPK.class)
public class OptionCompatibilityEntity {
    private int option1;
    private int option2;

    @Id
    @Column(name = "option1")
    public int getOption1() {
        return option1;
    }

    public void setOption1(int option1) {
        this.option1 = option1;
    }

    @Id
    @Column(name = "option2")
    public int getOption2() {
        return option2;
    }

    public void setOption2(int option2) {
        this.option2 = option2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OptionCompatibilityEntity that = (OptionCompatibilityEntity) o;

        if (option1 != that.option1) return false;
        if (option2 != that.option2) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = option1;
        result = 31 * result + option2;
        return result;
    }
}
