package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/
@Entity
@Table(name = "User")
@NamedQuery(name = "getAllUsers", query = "SELECT u FROM User u")
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
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy = "user")
    private final List<Contract> contracts = new ArrayList();


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

    public User(String name, String secondName, String birthdayData, String passport, String adress, String email, String password) {
        this.name = name;
        this.secondName = secondName;
        this.birthdayData = birthdayData;
        this.passport = passport;
        this.adress = adress;
        this.email = email;
        this.password = password;
    }
}
