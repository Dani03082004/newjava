package com.example.softlearning_springboot.applicationcore.entity.client.dtos;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

// Client + User
@Entity
@Table(name = "clients")
public class ClientDTO {
    @Id
    @Column(name = "id")
    private int id;

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

    @Column(name = "dni")
    private String dni;

    @Column(name = "social_reason")
    private String social_reason;

    @Column(name = "phone_number")
    private int phone_number;

    @Column(name = "postal_code")
    private int postal_code;

    @Column(name = "age")
    private int age;

    @Column(name = "workers")
    private int workers;
    
    public ClientDTO() {
    }

    public ClientDTO(int id, String name, String address, String cognoms, String email, String birthday, String dni, String social_reason, int phoneNumber, int postalCode, int age, int workers) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cognoms = cognoms;
        this.email = email;
        this.birthday = birthday;
        this.dni = dni;
        this.social_reason = social_reason;
        this.phone_number = phoneNumber;
        this.postal_code = postalCode;
        this.age = age;
        this.workers = workers;
    }
    

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCognoms() {
        return cognoms;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getDni() {
        return dni;
    }

    public String getSocial_reason() {
        return social_reason;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public int getPostal_code() {
        return postal_code;
    }

    public int getAge() {
        return age;
    }

    public int getWorkers() {
        return workers;
    }

    @Override
    public String toString() {
        return "ClientDTO [id=" + id + ", name=" + name + ", address=" + address + ", cognoms=" + cognoms + ", email="
                + email + ", birthday=" + birthday + ", dni=" + dni + ", socialReason=" + social_reason + ", phoneNumber=" + phone_number + ", postalCode=" + postal_code
                + ", age=" + age + ", workers=" + workers + "]";
    }
}
