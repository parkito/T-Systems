package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/
@Entity
@Table(name = "Contract", uniqueConstraints = @UniqueConstraint(columnNames = {"number"}))
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

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private final List<TariffOption> tariffOptions = new ArrayList();

    @OneToOne
    @JoinColumn(name = "tariff_id")
    private Tariff tariff;

    public User getUser() {
        return user;
    }

//    @ManyToOne
//    @JoinColumn(name = "user_id", insertable = false, updatable = false)
//    private User employee;
//
//    public User getEmployee() {
//        return employee;
//    }

    public void setUser(User user) {
        this.user = user;
    }

//    public void setEmployee(User employee) {
//        this.employee = employee;
//    }

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

//    public void setEmployee(User employee) {
//        this.employee = employee;
//    }

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

//    public List<TariffOption> getTariffOptions() {
//        return tariffOptions;
//    }

    public Tariff getTariff() {
        return tariff;
    }

//    public User getEmployee() {
//        return employee;
//    }

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

}
