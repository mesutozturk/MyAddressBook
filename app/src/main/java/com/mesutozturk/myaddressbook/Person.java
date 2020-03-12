package com.mesutozturk.myaddressbook;

import java.util.UUID;

public class Person {
    //creating fileds for person object
    private String name;
    private String surname;
    private String phoneNumber;
    private UUID id;

    //person constructor
    public Person() {
        setId(UUID.randomUUID());
    }
    //encapsulated fields => Properties
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
