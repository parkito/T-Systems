package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/
@Entity
@Table(name = "Contract")
@NamedQuery(name = "Contract.getAll", query = "SELECT c FROM Contract c")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contract_id")
    private int contractId;
    @Basic
    @Column(name = "number")
    private String number;
    @Basic
    @Column(name = "isBlocked")
    private boolean isBlocked;
    @Basic
    @Column(name = "blockedByAdmin")
    private boolean blockedByAdmin;
    @Basic
    @Column(name = "whoBlocked_id", insertable = false, updatable = false)
    private String whoBlockedId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "ConnectedOptions",
            joinColumns = @JoinColumn(name = "contract_id"),
            inverseJoinColumns = @JoinColumn(name = "tariffOption_id"))
    private List<TariffOption> tariffOptions = new ArrayList();


    @OneToOne
    @JoinColumn(name = "tariff_id")
    private Tariff tariff;


    public Contract() {

    }

    public List<TariffOption> getTariffOptions() {
        return tariffOptions;
    }


    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }


    public Contract(String number, Tariff tariff) {
        this.number = number;
        this.tariff = tariff;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public boolean isBlockedByAdmin() {
        return blockedByAdmin;
    }


    public Tariff getTariff() {
        return tariff;
    }


    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public boolean getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(boolean isBlocked) {
        this.isBlocked = isBlocked;
    }


    public boolean getBlockedByAdmin() {
        return blockedByAdmin;
    }

    public void setBlockedByAdmin(boolean blockedByAdmin) {
        this.blockedByAdmin = blockedByAdmin;
    }


    public String getWhoBlockedId() {
        return whoBlockedId;
    }

    public void setWhoBlockedId(String whoBlockedId) {
        this.whoBlockedId = whoBlockedId;
    }

    public void removeOption(TariffOption tariffOption) {
        this.tariffOptions.remove(tariffOption);
    }

    public void removeAllOptions() {
        this.tariffOptions.clear();
    }

    public boolean isTariffOptionExists(TariffOption tariffOption) {
        return this.tariffOptions.contains(tariffOption);
    }

    public void addOption(TariffOption tariffOption) {
        if (!isTariffOptionExists(tariffOption))
            this.tariffOptions.add(tariffOption);
        else System.out.println("Option already exists");
    }

    public Contract(String number, User user, Tariff tariff) {
        this.number = number;
        this.isBlocked = false;
        this.blockedByAdmin = false;
        this.whoBlockedId = "null";
        this.user = user;
        this.tariff = tariff;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractId=" + contractId +
                ", number='" + number + '\'' +
                ", isBlocked=" + isBlocked +
                ", blockedByAdmin=" + blockedByAdmin +
                ", whoBlockedId='" + whoBlockedId + '\'' +
                ", user=" + user +
                ", tariffOptions=" + tariffOptions +
                ", tariff=" + tariff +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contract contract = (Contract) o;

        if (contractId != contract.contractId) return false;
        if (isBlocked != contract.isBlocked) return false;
        if (blockedByAdmin != contract.blockedByAdmin) return false;
        if (number != null ? !number.equals(contract.number) : contract.number != null) return false;
        if (whoBlockedId != null ? !whoBlockedId.equals(contract.whoBlockedId) : contract.whoBlockedId != null)
            return false;


        return true;
    }

    @Override
    public int hashCode() {
        int result = contractId;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (isBlocked ? 1 : 0);
        result = 31 * result + (blockedByAdmin ? 1 : 0);
        result = 31 * result + (whoBlockedId != null ? whoBlockedId.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (tariffOptions != null ? tariffOptions.hashCode() : 0);
        result = 31 * result + (tariff != null ? tariff.hashCode() : 0);
        return result;
    }
}
