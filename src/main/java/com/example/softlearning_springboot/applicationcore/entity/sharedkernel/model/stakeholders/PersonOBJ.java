package com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.stakeholders;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.domainservices.validations.Checker;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class PersonOBJ extends Person {

    @Override
    public String getContactData() {
        return "PersonOBJ [id=" + id + ", name=" + name + ", cognoms=" + cognoms + "]";
    }
    

}
