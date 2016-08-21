package com.tsystems.javaschool.jpa.hardcore;


import com.tsystems.javaschool.jpa.advanced.Student;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
@DiscriminatorValue(value = "2")
public class TeacherInheritedUser extends JSSuperUser {
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
        return "TeacherInheritedUser{" +
                "login=" + getLogin() +
                '}';
    }
}
