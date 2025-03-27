package com.example.softlearning_springboot.applicationcore.entity.client.model;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.domainservices.validations.Checker;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.stakeholders.CompanyData;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.stakeholders.Person;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.stakeholders.Stakeholder;

public class Client extends Person implements Stakeholder {
    protected String dni;
    protected int age;
    protected CompanyData comp;

    protected Client() {

    }

    // Al no ser abstracta, hemos de utilizar el GetInstance method
    // Todo lo que no sea abstracto, no hacer ni try ni catch (no es necesario)
    public static Client getInstance(int id, String name, String address, String cognoms, int phoneNumber,
            int postalCode, String email, String birthday, String dni, int age, int workers, String socialReason)
            throws BuildException {

        Client cl = new Client();
        StringBuilder message = new StringBuilder();


        if (!cl.setId(id)) {
            message.append("Bad ID; ");
        }

        if (!cl.setName(name)) {
            message.append("Bad Name; ");
        }

        if (!cl.setAddress(address)) {
            message.append("Bad Address; ");
        }

        if (!cl.setCognoms(cognoms)) {
            message.append("Bad Surname; ");
        }

        if (!cl.setPhoneNumber(phoneNumber)) {
            message.append("Bad Phone Number; ");
        }

        if (!cl.setPostalCode(postalCode)) {
            message.append("Bad Postal Code; ");
        }

        if (!cl.setEmail(email)) {
            message.append("Bad Email; ");
        }

        if (!cl.setBirthday(birthday)) {
            message.append("Bad Birthday; ");
        }

        if (!cl.setDNI(dni)) {
            message.append("Bad DNI; ");
        }

        if (!cl.setAge(age)) {
            message.append("Bad Age; ");
        }

        try {
            cl.comp = new CompanyData(workers, socialReason);
        } catch (Exception e) {
            message.append("Error al crear CompanyData: ").append(e.getMessage()).append("; ");
        }

        // Si hay algún mensaje de error, lanzamos una BuildException
        if (message.length() > 0) {
            throw new BuildException("Failed to create Client: " + message.toString());
        }

        return cl;
    }

    public String getDNI() {
        return this.dni;
    }

    public boolean setDNI(String dni) {
        if (Checker.NotNullEmptyString(dni) != 0) {
            return false;
        }
        if (Checker.validarDNI(dni) != 0) {
            return false;
        }
        this.dni = dni;
        return true;
    }

    public int getAge() {
        return this.age;
    }

    public boolean setAge(int age) {
        if (Checker.NotNegative(age) != 0) {
            return false;
        }
        this.age = age;
        return true;
    }

    public CompanyData getCompanyData() {
        return this.comp;
    }

    public void setCompanyData(CompanyData comp) {
        this.comp = comp;
    }

    @Override
    public String toString() {
        return "Client [dni=" + dni + ", age=" + age + "]";
    }

    @Override
    public String getData() {
        StringBuilder mensaje_cliente = new StringBuilder();
        mensaje_cliente.append(" su DNI es: ").append(this.getDNI());
        mensaje_cliente.append(", su edad es: ").append(this.getAge()).append(" años");
        mensaje_cliente.append(", tipo de empresa: ").append(comp.getCompanytype());
        mensaje_cliente.append(", número de trabajadores: ").append(comp.getWorkers());
        mensaje_cliente.append(", razón social: ").append(comp.getSocialreason());
        return mensaje_cliente.toString();
    }

    @Override
    public String getContactData() {
        StringBuilder mensaje_cliente = new StringBuilder();
        mensaje_cliente.append("ESTA ES LA INFORMACIÓN DEL CLIENTE: ");
        mensaje_cliente.append(" su nombre es: ").append(this.getName());
        mensaje_cliente.append(", sus apellidos son: ").append(this.getCognoms());
        mensaje_cliente.append(", la dirección es: ").append(this.getAddress());
        mensaje_cliente.append(", su correo electrónico es: ").append(this.getEmail());
        mensaje_cliente.append(", el teléfono correspondiente es: ").append(this.getPhoneNumber());
        mensaje_cliente.append(", el código postal es: ").append(this.getPostalCode());
        mensaje_cliente.append(", su DNI es: ").append(this.getDNI());
        mensaje_cliente.append(", su edad es: ").append(this.getAge()).append(" años");
        mensaje_cliente.append(", tipo de empresa: ").append(comp.getCompanytype());
        mensaje_cliente.append(", número de trabajadores: ").append(comp.getWorkers());
        mensaje_cliente.append(", razón social: ").append(comp.getSocialreason());
        return mensaje_cliente.toString();
    }
}
