package operator.entities;

/**
 * Created by Artyom Karnov on 10/6/16.
 * artyom-karnov@yandex.ru
 **/

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userId;
    private String name;
    private String secondName;
    private String birthdayData;
    private String passport;
    private String adress;
    private String balance;
    private String email;
    private String contracts;

    public UserDTO() {
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setBirthdayData(String birthdayData) {
        this.birthdayData = birthdayData;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContracts(String contracts) {
        this.contracts = contracts;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getBirthdayData() {
        return birthdayData;
    }

    public String getPassport() {
        return passport;
    }

    public String getAdress() {
        return adress;
    }

    public String getBalance() {
        return balance;
    }

    public String getEmail() {
        return email;
    }

    public String getContracts() {
        return contracts;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", birthdayData='" + birthdayData + '\'' +
                ", passport='" + passport + '\'' +
                ", adress='" + adress + '\'' +
                ", balance='" + balance + '\'' +
                ", email='" + email + '\'' +
                ", contracts='" + contracts + '\'' +
                '}';
    }
}
