package com.tsystems.javaschool.jpa.hardcore;


import com.tsystems.javaschool.jpa.advanced.Student;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="js_users")
public class TeacherUser extends JSMappedSuperUser {
    @OneToOne
    @JoinColumn(name = "padawan")
    private Student padawan;

    public Student getPadawan() {
        return padawan;
    }

    public void setPadawan(Student padawan) {
        this.padawan = padawan;
    }

    @Override
    public String toString() {
        return "TeacherUser{" +
                "login=" + getLogin()+"\n"+
                "padawan=" + padawan +
                '}';
    }
}
