package com.tsystems.javaschool.jpa.hardcore;


import javax.persistence.*;

@Inheritance
@Table(name="js_users")
@DiscriminatorColumn(name="type")
@Entity
public abstract class JSSuperUser {
    @Id
    private long id;
    private String login;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "JSSuperUser{" +
                "id=" + id +
                ", login='" + login + '\'' +
                '}';
    }
}
