package com.example.softlearning_springboot.applicationcore.entity.client.dtos;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
@Table(name = "clientes")
public class ClientSpanishDTO {
    @Column(name = "nombre")
    private String name;

    @Column(name = "direccion")
    private String address;

    @Column(name = "apellidos")
    private String cognoms;

    @Column(name = "emailesp")
    private String email;

    @Column(name = "cumple")
    private String birthday;

    @Column(name = "dniesp")
    private String dni;

    @Column(name = "social")
    private String social_reason;

    @Id
    @Column(name = "idesp")
    private int id;

    @Column(name = "telefono")
    private int phone_number;

    @Column(name = "codigo_postal")
    private int postal_code;

    @Column(name = "edad")
    private int age;

    @Column(name = "trabajadores")
    private int workers;

    // Constructor vacío
    public ClientSpanishDTO() {
    }

    // Constructor lleno
    public ClientSpanishDTO(String name, String address, String cognoms, String email, String birthday, String dni,
                            String social_reason, int id, int phone_number, int postal_code, int age, int workers) {
        this.name = name;
        this.address = address;
        this.cognoms = cognoms;
        this.email = email;
        this.birthday = birthday;
        this.dni = dni;
        this.social_reason = social_reason;
        this.id = id;
        this.phone_number = phone_number;
        this.postal_code = postal_code;
        this.age = age;
        this.workers = workers;
    }

    // ------------------------ GETTERS --------------------- //
    @JsonGetter("nombre")
    public String getName() {
        return name;
    }

    @JsonGetter("direccion")
    public String getAddress() {
        return address;
    }

    @JsonGetter("apellidos")
    public String getCognoms() {
        return cognoms;
    }

    @JsonGetter("emailesp")
    public String getEmail() {
        return email;
    }

    @JsonGetter("cumple")
    public String getBirthday() {
        return birthday;
    }

    @JsonGetter("dniesp")
    public String getDni() {
        return dni;
    }

    @JsonGetter("social")
    public String getSocial_reason() {
        return social_reason;
    }

    @JsonGetter("idesp")
    public int getId() {
        return id;
    }

    @JsonGetter("telefono")
    public int getPhone_Number() {
        return phone_number;
    }

    @JsonGetter("codigo_postal")
    public int getPostal_Code() {
        return postal_code;
    }

    @JsonGetter("edad")
    public int getAge() {
        return age;
    }

    @JsonGetter("trabajadores")
    public int getWorkers() {
        return workers;
    }

    // ------------------------ SETTERS --------------------- //
    @JsonSetter("nombre")
    public void setName(String name) {
        this.name = name;
    }

    @JsonSetter("direccion")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonSetter("apellidos")
    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    @JsonSetter("emailesp")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonSetter("cumple")
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @JsonSetter("dniesp")
    public void setDni(String dni) {
        this.dni = dni;
    }

    @JsonSetter("social")
    public void setSocial_reason(String socialreason) {
        this.social_reason = socialreason;
    }

    @JsonSetter("idesp")
    public void setId(int id) {
        this.id = id;
    }

    @JsonSetter("telefono")
    public void setPhone_Number(int phoneNumber) {
        this.phone_number = phoneNumber;
    }

    @JsonSetter("codigo_postal")
    public void setPostal_Code(int postalCode) {
        this.postal_code = postalCode;
    }

    @JsonSetter("edad")
    public void setAge(int age) {
        this.age = age;
    }

    @JsonSetter("trabajadores")
    public void setWorkers(int workers) {
        this.workers = workers;
    }

    @Override
    public String toString() {
        return "ClientSpanishDTO [name=" + name + ", address=" + address + ", cognoms=" + cognoms + ", email=" + email
                + ", birthday=" + birthday + ", dni=" + dni + ", socialreason="
                + social_reason + ", id=" + id + ", phoneNumber=" + phone_number + ", postalCode=" + postal_code + ", age="
                + age + ", workers=" + workers + "]";
    }
}
