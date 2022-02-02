package com.sda.manandrada.bms.model;

import javax.persistence.*;

@Entity
@Table(name = "autor")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//pt a avea partea de generare
    @Column(name = "id")
    private Integer id;
    @Column(name = "first_name")//asa e formatul in baza de date
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //acest constructor obligatori,hibernate nu functioneaza fara el
    public Author() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
