package com.example.softlearning_springboot.applicationcore.entity.employee.dtos;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

// Employee + Person
@Entity
@Table(name = "employees")
public class EmployeeDTO {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "phone_number")
    private int phone_number;
    @Column(name = "postal_code")
    private int postal_code;
    @Column(name = "salary")
    private int salary;
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
    @Column(name = "role")
    private String role;
    @Column(name = "user")
    private String user;
    @Column(name = "password")
    private String password;
    @Column(name = "days")
    private String days;

    // Constructor vacio
    public EmployeeDTO() {
    }

    // Constructor lleno
    public EmployeeDTO(int id, int phone_number, int postal_code, int salary, String name, String address, String cognoms,
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

    public int getId() {
        return id;
    }
    
    public int getPhone_number() {
        return phone_number;
    }

    public int getPostal_code() {
        return postal_code;
    }

    public int getSalary() {
        return salary;
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

    public String getRole() {
        return role;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
    
    public String getDays() {
        return days;
    }

    @Override
    public String toString() {
        return "EmployeeDTO [id=" + id + ", phone_number=" + phone_number + ", postal_code=" + postal_code + ", salary="
                + salary + ", name=" + name + ", address=" + address + ", cognoms=" + cognoms + ", email=" + email
                + ", birthday=" + birthday + ", role=" + role + ", user=" + user + ", password=" + password + ", days="
                + days + "]";
    }

}
