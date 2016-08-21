package base;

import org.hibernate.annotations.Generated;

import javax.persistence.*;

/**
 * Created by Artyom Karnov on 8/21/16.
 * artyom-karnov@yandex.ru
 **/
@Entity
public class Client {
    private int id;
    private String name;
    private String secondName;
    private String birthdayData;
    private String passport;
    private String adress;
    private String eMail;
    private String password;

    @Id
//    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "secondName")
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Basic
    @Column(name = "birthdayData")
    public String getBirthdayData() {
        return birthdayData;
    }

    public void setBirthdayData(String birthdayData) {
        this.birthdayData = birthdayData;
    }

    @Basic
    @Column(name = "passport")
    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Basic
    @Column(name = "adress")
    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Basic
    @Column(name = "e-mail")
    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Client(int id, String name, String secondName, String birthdayData, String passport, String adress, String eMail, String password) {
        this.id = id;
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
