package com.tsystems.javaschool.jpa.advanced;
import com.tsystems.javaschool.jpa.basic.Schooler;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table (name="js_student")
public class Student {
    @Id
    @GeneratedValue
    private long id;

    @Column(name="first_name")
    @NotNull(message = "Имя не может быть пустым")
    private String firstName;

    @Column(name="last_name")
    @Size(min=5, max=25)
    private String lastName;

    @Column(name="date_of_birth")
    private Date birthDate;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private JavaSchool school;

    @OneToMany(mappedBy = "student")
    private List<EntranceAttemp> attemps;

    @ManyToMany
    @JoinTable(name="js_schedule",
            joinColumns=@JoinColumn(name="student_id"),
            inverseJoinColumns=@JoinColumn(name="lecture_id"))
    private List<Lecture> lectures;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public JavaSchool getSchool() {
        return school;
    }

    public void setSchool(JavaSchool school) {
        this.school = school;
    }

    public List<EntranceAttemp> getAttemps() {
        return attemps;
    }

    public void setAttemps(List<EntranceAttemp> attemps) {
        this.attemps = attemps;
    }

    public List<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", school=" + school +
                ", attemps=" + attemps +
                ", lectures=" + lectures +
                '}';
    }
}
