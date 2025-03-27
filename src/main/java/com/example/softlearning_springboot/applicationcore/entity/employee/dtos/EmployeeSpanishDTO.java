package com.example.softlearning_springboot.applicationcore.entity.employee.dtos;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleados")
public class EmployeeSpanishDTO {
    @Id
    @Column(name = "id_empleado")
    private int id;

    @Column(name = "telefono_empleado")
    private int phone_number;

    @Column(name = "codigo_empleado")
    private int postal_code;

    @Column(name = "salario_empleado")
    private int salary;

    @Column(name = "nombre_empleado")
    private String name;

    @Column(name = "direccion_empleado")
    private String address;

    @Column(name = "apellidos_empleado")
    private String cognoms;

    @Column(name = "email_empleado")
    private String email;

    @Column(name = "cumple_empleado")
    private String birthday;

    @Column(name = "rol_empleado")
    private String role;

    @Column(name = "user_empleado")
    private String user;

    @Column(name = "password_empleado")
    private String password;

    @Column(name = "dias_empleado")
    private String days;

    
    public EmployeeSpanishDTO() {
    }

    public EmployeeSpanishDTO(int id, int phone_number, int postal_code, int salary, String name, String address, String cognoms,
            String email, String birthday, String role, String user, String password, String days) {
        this.id = id;
        this.phone_number = phone_number;
        this.postal_code = postal_code;
        this.salary = salary;
        this.name = name;
        this.address = address;
        this.cognoms = cognoms;
        this.email = email;
        this.birthday = birthday;
        this.role = role;
        this.user = user;
        this.password = password;
        this.days = days;
    }

    // ------------------------ GETTERS --------------------- //
    @JsonGetter("id_empleado")
    public int getId() {
        return id;
    }

    @JsonGetter("telefono_empleado")
    public int getPhone_Number() {
        return phone_number;
    }

    @JsonGetter("codigo_empleado")
    public int getPostal_Code() {
        return postal_code;
    }

    @JsonGetter("salario_empleado")
    public int getSalary() {
        return salary;
    }

    @JsonGetter("nombre_empleado")
    public String getName() {
        return name;
    }

    @JsonGetter("direccion_empleado")
    public String getAddress() {
        return address;
    }

    @JsonGetter("apellidos_empleado")
    public String getCognoms() {
        return cognoms;
    }

    @JsonGetter("email_empleado")
    public String getEmail() {
        return email;
    }

    @JsonGetter("cumple_empleado")
    public String getBirthday() {
        return birthday;
    }

    @JsonGetter("rol_empleado")
    public String getRole() {
        return role;
    }

    @JsonGetter("user_empleado")
    public String getUser() {
        return user;
    }

    @JsonGetter("password_empleado")
    public String getPassword() {
        return password;
    }

    @JsonGetter("dias_empleado")
    public String getDays() {
        return days;
    }

    // ------------------------ SETTERS --------------------- //
    @JsonSetter("id_empleado")
    public void setId(int id) {
        this.id = id;
    }

    @JsonSetter("telefono_empleado")
    public void setPhone_Number(int phone_number) {
        this.phone_number = phone_number;
    }

    @JsonSetter("codigo_empleado")
    public void setPostal_Code(int postal_code) {
        this.postal_code = postal_code;
    }

    @JsonSetter("salario_empleado")
    public void setSalary(int salary) {
        this.salary = salary;
    }

    @JsonSetter("nombre_empleado")
    public void setName(String name) {
        this.name = name;
    }

    @JsonSetter("direccion_empleado")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonSetter("apellidos_empleado")
    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    @JsonSetter("email_empleado")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonSetter("cumple_empleado")
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @JsonSetter("rol_empleado")
    public void setRole(String role) {
        this.role = role;
    }

    @JsonSetter("user_empleado")
    public void setUser(String user) {
        this.user = user;
    }

    @JsonSetter("password_empleado")
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonSetter("dias_empleado")
    public void setDays(String days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return "EmployeeSpanishDTO [id=" + id + ", phoneNumber=" + phone_number + ", postalCode=" + postal_code
                + ", salary=" + salary + ", name=" + name + ", address=" + address + ", cognoms=" + cognoms + ", email="
                + email + ", birthday=" + birthday + ", role=" + role + ", user=" + user + ", password=" + password
                + ", days=" + days + "]";
    }
}
