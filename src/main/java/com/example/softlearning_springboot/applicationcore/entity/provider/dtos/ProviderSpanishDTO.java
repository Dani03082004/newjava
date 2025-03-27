package com.example.softlearning_springboot.applicationcore.entity.provider.dtos;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Provider + Person en español
@Entity
@Table(name = "proveedores")
public class ProviderSpanishDTO{
    @Id
    @Column(name = "id_proveedor")
    private int id;

    @Column(name = "telefono_proveedor")
    private int phone_number;

    @Column(name = "codigo_proveedor")
    private int postal_code;

    @Column(name = "trabajadores_proveedor")
    private int workers;

    @Column(name = "nombre_proveedor")
    private String name;

    @Column(name = "direccion_proveedor")
    private String address;

    @Column(name = "apellidos_proveedor")
    private String cognoms;

    @Column(name = "email_proveedor")
    private String email;

    @Column(name = "cumpleaños_proveedor")
    private String birthday;

    @Column(name = "horario_proveedor")
    private String schedule;

    @Column(name = "trabajo_proveedor")
    private String work;

    @Column(name = "usuario_proveedor")
    private String user;

    @Column(name = "contraseña_proveedor")
    private String password;

    @Column(name = "razon_social_proveedor")
    private String social_reason;

    // Constructor vacio
    public ProviderSpanishDTO() {
    }

    // Constructor lleno
    public ProviderSpanishDTO(int id, int phone_number, int postal_code, int workers, String name, String address,
            String cognoms, String email, String birthday, String schedule, String work,
            String user, String password, String social_reason) {
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

    // ------------------------ GETTERS --------------------- //
    @JsonGetter("id_proveedor")
    public int getId() {
        return id;
    }

    @JsonGetter("telefono_proveedor")
    public int getPhone_number() {
        return phone_number;
    }

    @JsonGetter("codigo_proveedor")
    public int getPostal_Code() {
        return postal_code;
    }

    @JsonGetter("trabajadores_proveedor")
    public int getWorkers() {
        return workers;
    }

    @JsonGetter("nombre_proveedor")
    public String getName() {
        return name;
    }

    @JsonGetter("direccion_proveedor")
    public String getAddress() {
        return address;
    }

    @JsonGetter("apellidos_proveedor")
    public String getCognoms() {
        return cognoms;
    }

    @JsonGetter("email_proveedor")
    public String getEmail() {
        return email;
    }

    @JsonGetter("cumpleaños_proveedor")
    public String getBirthday() {
        return birthday;
    }

    @JsonGetter("horario_proveedor")
    public String getSchedule() {
        return schedule;
    }

    @JsonGetter("trabajo_proveedor")
    public String getWork() {
        return work;
    }

    @JsonGetter("usuario_proveedor")
    public String getUser() {
        return user;
    }

    @JsonGetter("contraseña_proveedor")
    public String getPassword() {
        return password;
    }

    @JsonGetter("razon_social_proveedor")
    public String getSocial_reason() {
        return social_reason;
    }

    // ------------------------ SETTERS --------------------- //
    @JsonSetter("id_proveedor")
    public void setId(int id) {
        this.id = id;
    }

    @JsonSetter("telefono_proveedor")
    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    @JsonSetter("codigo_proveedor")
    public void setPostal_Code(int postal_code) {
        this.postal_code = postal_code;
    }

    @JsonSetter("trabajadores_proveedor")
    public void setWorkers(int workers) {
        this.workers = workers;
    }

    @JsonSetter("nombre_proveedor")
    public void setName(String name) {
        this.name = name;
    }

    @JsonSetter("direccion_proveedor")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonSetter("apellidos_proveedor")
    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    @JsonSetter("email_proveedor")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonSetter("cumpleaños_proveedor")
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @JsonSetter("horario_proveedor")
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    @JsonSetter("trabajo_proveedor")
    public void setWork(String work) {
        this.work = work;
    }

    @JsonSetter("usuario_proveedor")
    public void setUser(String user) {
        this.user = user;
    }

    @JsonSetter("contraseña_proveedor")
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonSetter("razon_social_proveedor")
    public void setSocial_reason(String social_reason) {
        this.social_reason = social_reason;
    }

    @Override
    public String toString() {
        return "ProviderSpanishDTO [id=" + id + ", phone_Number=" + phone_number + ", postalCode=" + postal_code
                + ", workers="
                + workers + ", name=" + name + ", address=" + address + ", cognoms=" + cognoms + ", email=" + email
                + ", birthday=" + birthday + ", schedule=" + schedule + ", work=" + work + ", user=" + user
                + ", password=" + password + ", socialreason=" + social_reason + "]";
    }
}
