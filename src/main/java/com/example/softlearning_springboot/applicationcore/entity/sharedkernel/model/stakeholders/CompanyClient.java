package com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.stakeholders;

import com.example.softlearning_springboot.applicationcore.entity.client.model.Client;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.domainservices.validations.Checker;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class CompanyClient extends Client {
    protected CompanyData comp;

    public CompanyClient() {
        this.comp = new CompanyData();
    }

    public static CompanyClient getInstance(int workers, String socialReason, String dni, int age)
            throws BuildException {

        CompanyClient cp = new CompanyClient();
        StringBuilder message = new StringBuilder();

        try {
            cp.comp = new CompanyData(workers, socialReason);
        } catch (BuildException e) {
            message.append("Failed to create Company Data: ").append(e.getMessage()).append("; ");
        }

        if (!cp.setDNI(dni)) {
            message.append("Bad DNI; ");
        }
        if (!cp.setAge(age)) {
            message.append("Bad Age; ");
        }

        if (message.length() > 0) {
            throw new BuildException("Failed to create Company Client: " + message.toString());
        }

        return cp;
    }

    public int getWorkers() {
        return this.comp.getWorkers();
    }

    public String getSocialReason() {
        return this.comp.getSocialreason();
    }

    public String getCompanyType() {
        return this.comp.getCompanytype();
    }

    public void setCompanyType(String companyType) {
        this.comp.setCompanytype(companyType);
    }

    public boolean setWorkers(int workers) {
        if (Checker.isNegativeInt(workers)) {
            return false; 
        }

        if (Checker.minValue(workers, 1) != 0) {
            return false; 
        }

        this.comp.setWorkers(workers);
        return true; 
    }

    public boolean setSocialReason(String socialReason) {
        if (Checker.NotNullEmptyString(socialReason) != 0) {
            return false;
        }
        if (!Checker.minLength(socialReason, 5)) {
            return false; 
        }
        this.comp.setSocialReason(socialReason);
        return true; 
    }
}
