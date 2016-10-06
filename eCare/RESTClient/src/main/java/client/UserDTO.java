package client;

/**
 * Created by Artyom Karnov on 10/6/16.
 * artyom-karnov@yandex.ru
 **/

import java.io.Serializable;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userId;
    private String name;
    private String secondName;
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
                ", email='" + email + '\'' +
                ", contracts='" + contracts + '\'' +
                '}';
    }
}
