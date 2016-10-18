package com.tsystems.javaschool.jpa.advanced;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="entranceAttemp")
@Table(name="js_entrance_test")
public class EntranceAttemp {
    @Id
    private long id;
    private long note;
    @ManyToOne
    private Student student;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNote() {
        return note;
    }

    public void setNote(long note) {
        this.note = note;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


    @Override
    public String toString() {
        return "EntranceAttemp{" +
                "id=" + id +
                ", note=" + note +
                '}';
    }
}
