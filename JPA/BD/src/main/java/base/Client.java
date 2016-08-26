package base;

import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Artyom Karnov on 8/21/16.
 * artyom-karnov@yandex.ru
 **/
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "secondName")
    private String secondName;
    @Basic
    @Column(name = "birthdayData")
    private String birthdayData;
    @Basic
    @Column(name = "passport")
    private String passport;
    @Basic
    @Column(name = "adress")
    private String adress;
    @Basic
    @Column(name = "email")
    private String eMail;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "status")
    private String status;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Client_has_Contract",
            joinColumns = @JoinColumn(name = "Client_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "Contract_number", referencedColumnName = "number"))
    private Set<Contract> contracts;

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }


    public String getBirthdayData() {
        return birthdayData;
    }

    public void setBirthdayData(String birthdayData) {
        this.birthdayData = birthdayData;
    }


    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }


    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }


    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Client(String name, String secondName, String birthdayData,
                  String passport, String adress, String eMail, String password) {
        this.name = name;
        this.secondName = secondName;
        this.birthdayData = birthdayData;
        this.passport = passport;
        this.adress = adress;
        this.eMail = eMail;
        this.password = password;
    }

    public Client() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (id != client.id) return false;
        if (name != null ? !name.equals(client.name) : client.name != null) return false;
        if (secondName != null ? !secondName.equals(client.secondName) : client.secondName != null) return false;
        if (birthdayData != null ? !birthdayData.equals(client.birthdayData) : client.birthdayData != null)
            return false;
        if (passport != null ? !passport.equals(client.passport) : client.passport != null) return false;
        if (adress != null ? !adress.equals(client.adress) : client.adress != null) return false;
        if (eMail != null ? !eMail.equals(client.eMail) : client.eMail != null) return false;
        if (password != null ? !password.equals(client.password) : client.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (birthdayData != null ? birthdayData.hashCode() : 0);
        result = 31 * result + (passport != null ? passport.hashCode() : 0);
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
