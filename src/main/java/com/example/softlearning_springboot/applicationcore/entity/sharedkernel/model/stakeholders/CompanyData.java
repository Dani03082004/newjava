package com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.stakeholders;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.domainservices.validations.Checker;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class CompanyData {
    protected int workers;
    protected String socialreason;
    protected String companytype;

    public CompanyData() {
    }

    public CompanyData(int workers, String socialreason) throws BuildException {
        StringBuilder message = new StringBuilder();
        
        if (!this.setWorkers(workers)) {
            message.append("Bad Workers; ");
        }

        if (!this.setSocialReason(socialreason)) {
            message.append("Bad Social Reason; ");
        }
        if (message.length() > 0) {
            throw new BuildException("Failed to create Company Data: " + message.toString());
        }
    }

    public int getWorkers() {
        return workers;
    }

    public String getSocialreason() {
        return socialreason;
    }

    public String getCompanytype() {
        return companytype;
    }

    public void setCompanytype(String companytype) {
        this.companytype = companytype;
    }

    public boolean setWorkers(int workers) {
        if (Checker.isNegativeInt(workers)) {
            return false; 
        }
        
        this.workers = workers; 
        
        if (workers > 250) {
            companytype = "Big Company";
        } else if (workers <= 50) {
            companytype = "Small Company";
        } else {
            companytype = "Medium Company";
        }

        return true;
    }

    public boolean setSocialReason(String socialReason) {
        if (Checker.NotNullEmptyString(socialReason) != 0) {
            return false; 
        }
        if (!Checker.minLength(socialReason, 5)) {
            return false;
        }
        
        this.socialreason = socialReason; 
        return true;
    }
}

