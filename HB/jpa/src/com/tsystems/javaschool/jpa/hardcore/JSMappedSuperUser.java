package com.tsystems.javaschool.jpa.hardcore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@MappedSuperclass
@Table(name="js_users")
public class JSMappedSuperUser {
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
        return "JSMappedSuperUser{" +
                "id=" + id +
                ", login='" + login + '\'' +
                '}';
    }
}
