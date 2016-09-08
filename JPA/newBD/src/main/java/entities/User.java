package entities;

import services.api.AccessLevelService;
import services.implementation.AccessLevelImpl;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/
@Entity
@Table(name = "User")
@NamedQuery(name = "User.getAll", query = "SELECT u FROM User u")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int userId;
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
    @Column(name = "balance")
    private double balance;
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "accessLevel_id")
    private AccessLevel accessLevel;

    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private final List<Contract> contracts = new ArrayList();

    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
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


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public User(String name, String secondName, String birthdayData,
                String passport, String adress,
                String email, String password) {
        this.name = name;
        this.secondName = secondName;
        this.birthdayData = birthdayData;
        this.passport = passport;
        this.adress = adress;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", birthdayData='" + birthdayData + '\'' +
                ", passport='" + passport + '\'' +
                ", adress='" + adress + '\'' +
                ", balance=" + balance +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", accessLevel=" + accessLevel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

//        if (userId != user.userId) return false;
        if (Double.compare(user.balance, balance) != 0) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (secondName != null ? !secondName.equals(user.secondName) : user.secondName != null) return false;
        if (birthdayData != null ? !birthdayData.equals(user.birthdayData) : user.birthdayData != null) return false;
        if (passport != null ? !passport.equals(user.passport) : user.passport != null) return false;
        if (adress != null ? !adress.equals(user.adress) : user.adress != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
//        if (accessLevel != null ? !accessLevel.equals(user.accessLevel) : user.accessLevel != null) return false;
//        if (contracts != null ? !contracts.equals(user.contracts) : user.contracts != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = userId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (birthdayData != null ? birthdayData.hashCode() : 0);
        result = 31 * result + (passport != null ? passport.hashCode() : 0);
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (accessLevel != null ? accessLevel.hashCode() : 0);
        result = 31 * result + (contracts != null ? contracts.hashCode() : 0);
        return result;
    }
}
