package com.registry.estates.entity;

import javax.persistence.*;

@Entity
@Table(name = "owner")
public class Owner {
    private String name;
    private String lastName;
    private String email;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    public Owner(String name, String lastName, String email, short id) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.id = id;
    }

    public Owner() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }
}
