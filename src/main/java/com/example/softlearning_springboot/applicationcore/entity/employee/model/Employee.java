package com.example.softlearning_springboot.applicationcore.entity.employee.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.domainservices.validations.Checker;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.domainservices.validations.Checker.DateException;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.stakeholders.Person;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.stakeholders.Stakeholder;


public class Employee extends Person implements Stakeholder {
    protected int salary;
    protected String role;
    protected String user;
    protected String password;
    protected LocalDate days; // Fecha contrato

    protected Employee() {
    }

    public static Employee getInstance(int id, String name, String address, String cognoms, int phoneNumber,
            int postalCode, String email,
            String birthday, int salary, String role, String user, String password, String days)
            throws BuildException, DateException {

        Employee e = new Employee();
        StringBuilder message = new StringBuilder();

        if (!e.setSalary(salary)) {
            message.append("Bad salary; ");
        }
        if (!e.setRole(role)) {
            message.append("Bad role; ");
        }
        if (!e.setUser(user)) {
            message.append("Bad user; ");
        }
        if (!e.setPassword(password)) {
            message.append("Bad password; ");
        }

        try {
            if (!e.setDays(days)) {
                message.append("Bad day; ");
            }
        } catch (DateException ex) {
            message.append("Invalid date format; ");
        }

        try {
            e.CheckPersonData(id, name, address, cognoms, phoneNumber, postalCode, email, birthday); 
        } catch (BuildException ex) {
            System.err.println("Failed to create Employee: " + ex.getMessage());
        }

        if (message.length() > 0) {
            throw new BuildException("Failed to create Employee: " + message.toString());
        }
        return e;
    }

    // Función para mostrar los dias restantes hasta la finalización del contranto
    public int getDaysRemaining() {
        LocalDate hoy = LocalDate.now();
        Period diferencia = Period.between(hoy, this.days);
        return diferencia.getDays();
    }

    public int getSalary() {
        return salary;
    }

    public boolean setSalary(int salary) {
        if (Checker.NotNegative((int) salary) != 0) {
            return false;
        }
        if (Checker.minValue(salary, 5) != 0) {
            return false; 
        }
        this.salary = salary;
        return true;
    }

    public String getRole() {
        return role;
    }

    public boolean setRole(String role) {
        if (Checker.NotNullEmptyString(role) != 0) {
            return false; // Retorna false si es nulo o vacío
        }
        if (!Checker.minLength(role, 5)) {
            return false; // Retorna false si es menos de 5
        }
        this.role = role;
        return true;
    }

    public String getUser() {
        return user;
    }

    public boolean setUser(String user) {
        if (Checker.NotNullEmptyString(user) != 0) {
            return false; 
        }
        if (!Checker.minLength(user, 5)) { 
            return false; 
        }
        this.user = user;
        return true;
    }

    public String getPassword() {
        return password;
    }

    public boolean setPassword(String password) {
        if (Checker.NotNullEmptyString(password) != 0) {
            return false;
        }
        if (Checker.PasswordMinLength(password, 8) != 0) {
            return false;
        }
        this.password = password;
        return true;
    }

    public LocalDate getDays() {
        return days;
    }

    public boolean setDays(String days) throws DateException {
        try {
            // Formato que queremos: dd-MM-yyyy
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            this.days = LocalDate.parse(days, formatter);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    @Override
    public String toString() {
        return "Employee [user=" + user + ", password=" + password + "]";
    }

    @Override
    public String getData() {
        StringBuilder mensaje_empleado = new StringBuilder();
        mensaje_empleado.append("ESTA ES LA INFORMACIÓN DEL EMPLEADO:");
        mensaje_empleado.append(" el turno que hace es de: ").append(this.role);
        mensaje_empleado.append(", el sueldo que tiene es de: ").append(this.salary).append("€");
        mensaje_empleado.append(", días Restantes para finalizar el contrato: ").append(this.getDaysRemaining());
        mensaje_empleado.append(", el usuario del proveedor es: ").append(this.user);
        mensaje_empleado.append(", la contraseña del proveedor es: ").append(this.password);
        return mensaje_empleado.toString();
    }

    @Override
    public String getContactData() {
        StringBuilder mensaje_empleado = new StringBuilder();
        mensaje_empleado.append("ESTA ES LA INFORMACIÓN DEL EMPLEADO: ");
        mensaje_empleado.append(" su nombre es: ").append(this.getName());
        mensaje_empleado.append(", sus apellidos son: ").append(this.getCognoms());
        mensaje_empleado.append(", la dirección es: ").append(this.getAddress());
        mensaje_empleado.append(", su correo electrónico es: ").append(this.getEmail());
        mensaje_empleado.append(", su cumpleaños es: ").append(this.getBirthday());
        mensaje_empleado.append(", el teléfono correspondiente es: ").append(this.getPhoneNumber());
        mensaje_empleado.append(", el código postal es: ").append(this.getPostalCode());
        mensaje_empleado.append(", el turno que hace es de: ").append(this.getRole());
        mensaje_empleado.append(", el sueldo que tiene es de: ").append(this.getSalary()).append("€");
        mensaje_empleado.append(", días Restantes para Finalizar su contrato: ").append(this.getDaysRemaining());
        mensaje_empleado.append(", el usuario del proveedor es: ").append(this.getUser());
        mensaje_empleado.append(", la contraseña del proveedor es: ").append(this.getPassword());
        return mensaje_empleado.toString();
    }

}

