package com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.operations;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.domainservices.validations.Checker;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.domainservices.validations.Checker.DateException;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;


public abstract class Operation {
    protected int reference; // referencia de la operacion
    protected String description;
    protected LocalDateTime initdate, finishdate;
    protected DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    protected Operation() {
    }

    public void CheckOperData(int reference, String description, String initdate)
            throws BuildException, DateException {
        StringBuilder message = new StringBuilder();
        if (!this.setReference(reference)) {
            message.append("Bad Reference; ");
        }
        if (!this.setDescription(description)) {
            message.append("Bad description; ");
        }
        if (!this.setInitDate(initdate)) {
            message.append("Bad Init Date; ");
        }

        if (message.length() > 0) {
            throw new BuildException("Not possible to create the object: " + message.toString());
        }
    }

    public int getReference() {
        return reference;
    }

    public boolean setReference(int reference) {
        if (Checker.NotNegative(reference) != 0) {
            return false;
        }
        this.reference = reference;
        return true;
    }

    public String getStatus() {
        return getStatus();
    }

    public String getDescription() {
        return description;
    }

    public boolean setDescription(String description) {
        if (Checker.NotNullEmptyString(description) != 0) {
            return false;
        }
        if (Checker.hasSpaces(description)) {
            return false;
        }
        if (!Checker.minLength(description, 5)) {
            return false;
        }
        this.description = description;
        return true;
    }

    public String getInitdate() {
        return initdate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    // Implementar Order Status --> CREATED --> CONFIRMED
    public boolean setInitDate(String initdate) throws DateException {
        if (Checker.NotNullEmptyString(initdate) == 0) {
            this.initdate = Checker.checkDateTimes(initdate);
            return true;
        }
        return false;
    }

    public String getFinishdate() {
        return finishdate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    // Implementar Order Status --> DELIVERED --> FINISHED
    public boolean setFinishDate(String finishdate) throws DateException {
        if (Checker.NotNullEmptyString(finishdate) == 0) {
            LocalDateTime date = Checker.checkDateTimes(finishdate);
            if (date != null) {
                this.finishdate = date;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Operation [reference=" + reference + ", description=" + description + "]";
    }

    public String getData() {
        StringBuilder mensaje_operation = new StringBuilder();
        mensaje_operation.append("ESTA ES LA INFORMACIÓN DE LA OPERACIÓN: ");
        mensaje_operation.append(" el id de la operación es: ").append(this.getReference());
        mensaje_operation.append(", la descripción es: ").append(this.getDescription());
        mensaje_operation.append(", el status es: ").append(this.getStatus());
        mensaje_operation.append(", la fecha de inicio es: ").append(this.getInitdate());
        mensaje_operation.append(", la fecha de finalización es: ").append(this.getFinishdate());
        mensaje_operation.append(", el estado de la operación es: ").append(this.getStatus());
        return mensaje_operation.toString();
    }

    public abstract String getContactData();

    public abstract String getDetails();
}