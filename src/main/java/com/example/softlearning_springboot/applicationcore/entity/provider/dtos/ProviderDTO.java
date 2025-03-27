package com.example.softlearning_springboot.applicationcore.entity.provider.dtos;

import com.fasterxml.jackson.annotation.JsonGetter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Provider + Person
@Entity
@Table(name = "providers")
public class ProviderDTO {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "phone_number")
    private int phone_number;

    @Column(name = "postal_code")
    private int postal_code;

    @Column(name = "workers")
    private int workers;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "cognoms")
    private String cognoms;

    @Column(name = "email")
    private String email;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "schedule")
    private String schedule;

    @Column(name = "work")
    private String work; 

    @Column(name = "user")
    private String user;

    @Column(name = "password")
    private String password;

    @Column(name = "social_reason")
    private String social_reason;

    // Constructor vacio
    public ProviderDTO() {
    }

    // Constructor lleno
    public ProviderDTO(int id, int phone_number, int postal_code, int workers, String name, String address,
            String cognoms, String email, String birthday, String schedule, String work, String user, String password,
            String social_reason) {
        this.id = id;
        this.phone_number = phone_number;
        this.postal_code = postal_code;
        this.workers = workers;
        this.name = name;
        this.address = address;
        this.cognoms = cognoms;
        this.email = email;
        this.birthday = birthday;
        this.schedule = schedule;
        this.work = work;
        this.user = user;
        this.password = password;
        this.social_reason = social_reason;
    }

    @JsonGetter("id")
    public int getId() {
        return id;
    }

    @JsonGetter("phone_number")
    public int getPhone_number() {
        return phone_number;
    }

    @JsonGetter("postal_code")
    public int getPostal_code() {
        return postal_code;
    }

    @JsonGetter("workers")
    public int getWorkers() {
        return workers;
    }

    @JsonGetter("name")
    public String getName() {
        return name;
    }

    @JsonGetter("address")
    public String getAddress() {
        return address;
    }

    @JsonGetter("cognoms")
    public String getCognoms() {
        return cognoms;
    }

    @JsonGetter("email")
    public String getEmail() {
        return email;
    }

    @JsonGetter("birthday")
    public String getBirthday() {
        return birthday;
    }

    @JsonGetter("schedule")
    public String getSchedule() {
        return schedule;
    }

    @JsonGetter("work")
    public String getWork() {
        return work;
    }

    @JsonGetter("user")
    public String getUser() {
        return user;
    }

    @JsonGetter("password")
    public String getPassword() {
        return password;
    }

    @JsonGetter("social_reason")
    public String getSocial_reason() {
        return social_reason;
    }

    @Override
    public String toString() {
        return "ProviderDTO [id=" + id + ", phoneNumber=" + phone_number + ", postalCode=" + postal_code + ", workers=" 
                + workers + ", name=" + name + ", address=" + address + ", cognoms=" + cognoms + ", email=" + email 
                + ", birthday=" + birthday + ", schedule=" + schedule + ", work=" + work + ", user=" + user 
                + ", password=" + password + ", socialreason=" + social_reason + "]";
    }
}
