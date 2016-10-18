package com.tsystems.javaschool.jpa.hardcore;

import com.tsystems.javaschool.jpa.advanced.Address;
import com.tsystems.javaschool.jpa.advanced.JavaSchool;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="js_student")
public class StudentWithEmbedded {
    @Id
    @GeneratedValue
    private long id;

    @Embedded
    private StudentName studentName;

    @Column(name="date_of_birth")
    private Date birthDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public StudentName getStudentName() {
        return studentName;
    }

    public void setStudentName(StudentName studentName) {
        this.studentName = studentName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "StudentWithEmbedded{" +
                "birthDate=" + birthDate +
                ", studentName=" + studentName +
                ", id=" + id +
                '}';
    }
}
