package com.example.softlearning_springboot.applicationcore.entity.provider.model;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.domainservices.validations.Checker;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.stakeholders.CompanyData;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.stakeholders.Person;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.stakeholders.Stakeholder;

public class Provider extends Person implements Stakeholder {
    protected String schedule;
    protected String work;
    protected String user;
    protected String password;
    protected CompanyData comp;

    protected Provider() {
    }

    public static Provider getInstance(String schedule, String work, String user, String password, 
                                       int workers, String socialReason, 
                                       int id, String name, String address, String cognoms,
                                       int phoneNumber, int postalCode, String email,
                                       String birthday) throws BuildException {
        Provider p = new Provider();
        StringBuilder message = new StringBuilder();

        try {
            p.comp = new CompanyData(workers, socialReason);
        } catch (Exception e) {
            message.append("Error al crear CompanyData: ").append(e.getMessage()).append("; ");
        }

        try {
            p.CheckPersonData(id, name, address, cognoms, phoneNumber, postalCode, email, birthday);
        } catch (BuildException ex) {
            System.err.println("Failed to create Provider: " + ex.getMessage());
        }

        if (!p.setSchedule(schedule)) {
            message.append("Bad Schedule; ");
        }
        if (!p.setWork(work)) {
            message.append("Bad Work; ");
        }
        if (!p.setUser(user)) {
            message.append("Bad User; ");
        }
        if (!p.setPassword(password)) {
            message.append("Bad Password; ");
        }

        if (message.length() > 0) {
            throw new BuildException("Failed to create Provider: " + message.toString());
        }
        return p;
    }

    public String getSchedule() {
        return schedule;
    }

    public boolean setSchedule(String schedule) {
        if (Checker.NotNullEmptyString(schedule) != 0) {
            return false;
        }
        if (Checker.hasSpaces(schedule)) {
            return false;
        }
        this.schedule = schedule;
        return true;
    }

    public String getWork() {
        return work;
    }

    public boolean setWork(String work) {
        if (Checker.NotNullEmptyString(work) != 0) {
            return false;
        }
        if (!Checker.minLength(work, 5)) {
            return false;
        }
        if (Checker.hasSpaces(work)) {
            return false;
        }
        this.work = work;
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

    public CompanyData getComp() {
        return comp;
    }

    public boolean setComp(CompanyData comp) {
        if (comp == null) {
            return false;
        }
        this.comp = comp;
        return true;
    }

    @Override
    public String toString() {
        return "Provider [work=" + work + ", user=" + user + "]";
    }

    @Override
    public String getData() {
        StringBuilder mensaje_proveedor = new StringBuilder();
        mensaje_proveedor.append("Información del Proveedor:");
        mensaje_proveedor.append(" horario: ").append(this.getSchedule());
        mensaje_proveedor.append(", trabajo: ").append(this.getWork());
        mensaje_proveedor.append(", usuario: ").append(this.getUser());
        mensaje_proveedor.append(", contraseña: ").append(this.getPassword());
        mensaje_proveedor.append(", empresa: ").append(comp.getCompanytype());
        mensaje_proveedor.append(", número de trabajadores: ").append(comp.getWorkers());
        mensaje_proveedor.append(", razón social: ").append(comp.getSocialreason());
        return mensaje_proveedor.toString();
    }

    @Override
    public String getContactData() {
        StringBuilder mensaje_proveedor = new StringBuilder();
        mensaje_proveedor.append("ESTA ES LA INFORMACIÓN DEL PROVEEDOR: ");
        mensaje_proveedor.append(" nombre: ").append(this.getName());
        mensaje_proveedor.append(", apellidos: ").append(this.getCognoms());
        mensaje_proveedor.append(", dirección: ").append(this.getAddress());
        mensaje_proveedor.append(", correo electrónico: ").append(this.getEmail());
        mensaje_proveedor.append(", teléfono: ").append(this.getPhoneNumber());
        mensaje_proveedor.append(", código postal: ").append(this.getPostalCode());
        mensaje_proveedor.append(", trabajo: ").append(this.getWork());
        mensaje_proveedor.append(", horario: ").append(this.getSchedule());
        mensaje_proveedor.append(", usuario: ").append(this.getUser());
        mensaje_proveedor.append(", contraseña: ").append(this.getPassword());
        mensaje_proveedor.append(", empresa: ").append(comp.getCompanytype());
        mensaje_proveedor.append(", número de trabajadores: ").append(comp.getWorkers());
        mensaje_proveedor.append(", razón social: ").append(comp.getSocialreason());
        return mensaje_proveedor.toString();
    }
}

