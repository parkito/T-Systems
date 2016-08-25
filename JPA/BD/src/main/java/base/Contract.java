package base;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/
@Entity
public class Contract {
    @Id
    @Column(name = "number")
    private String number;
    @Basic
    @Column(name = "status")
    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    private Tariff tariff;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "ConnectedOption",
            joinColumns = @JoinColumn(name = "Contract_number", referencedColumnName = "number"),
            inverseJoinColumns = @JoinColumn(name = "TariffOption_id", referencedColumnName = "id"))
    private Set<TariffOption> tariffOptions;

    public Set<TariffOption> getTariffOptions() {
        return tariffOptions;
    }

    public void setTariffOptions(Set<TariffOption> tariffOptions) {
        this.tariffOptions = tariffOptions;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    public Contract() {
    }

    public Contract(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contract contract = (Contract) o;

        if (number != null ? !number.equals(contract.number) : contract.number != null) return false;
        if (status != null ? !status.equals(contract.status) : contract.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = number != null ? number.hashCode() : 0;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
