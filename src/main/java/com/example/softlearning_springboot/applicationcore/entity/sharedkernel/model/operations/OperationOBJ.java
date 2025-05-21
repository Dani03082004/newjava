package com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.operations;

import java.time.format.DateTimeFormatter;

public class OperationOBJ extends Operation {

@Override
public String getContactData() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    String formattedInitDate = initdate != null ? initdate.format(formatter) : "null";
    return "OperationOBJ [reference=" + reference +
            ", description=" + description +
            ", initdate=" + formattedInitDate + "]";
}

@Override
public String getDetails() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    String formattedInitDate = initdate != null ? initdate.format(formatter) : "null";
    return "OperationOBJ [reference=" + reference +
            ", description=" + description +
            ", initdate=" + formattedInitDate + "]";
}

}