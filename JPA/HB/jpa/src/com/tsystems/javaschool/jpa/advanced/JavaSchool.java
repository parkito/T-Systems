package com.tsystems.javaschool.jpa.advanced;

import javax.persistence.*;

@Entity
@Table(name = "js_schools")
public class JavaSchool {
    @Id
    private long id;
    @Column(name="name")
    private String schoolName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }


    @Override
    public String toString() {
        return "JavaSchool{" +
                "id=" + id +
                ", schoolName='" + schoolName + '\'' +
                '}';
    }
}
