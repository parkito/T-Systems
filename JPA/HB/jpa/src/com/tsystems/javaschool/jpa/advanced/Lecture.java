package com.tsystems.javaschool.jpa.advanced;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="js_lection")
public class Lecture {
    @Id
    private long id;
    private String name;
    @ManyToMany(mappedBy = "lectures", cascade = CascadeType.ALL)
    private List<Student> students;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
