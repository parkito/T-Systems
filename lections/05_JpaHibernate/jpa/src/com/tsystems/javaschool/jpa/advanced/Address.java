package com.tsystems.javaschool.jpa.advanced;

import javax.persistence.*;


@Entity
@Table(name="address")
public class Address {
    @Id
    private long id;
    private String city;
    private String street;
    private int house;
    @OneToOne(mappedBy = "address")
    private Student student;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Address{" +
                "house=" + house +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", id=" + id +
                '}';
    }
}
