package com.example.softlearning_springboot.applicationcore.entity.sharedkernel.domainservices.validations;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.GeneralDateTimeException;

public class DataCheck {
    public static int checkDNI(String dni) {
        if (dni == null || dni.trim().length() != 9) {
            return -1;
        }
        return 0;
    }

    public static int checkEmail(String email) {
        if (email == null || !email.contains("@") || email.indexOf('@') == 0
                || email.indexOf('@') == email.length() - 1) {
            return -1;
        }
        String[] partes = email.split("@");
        String dominio = partes[1];
        return dominio.contains(".") ? 0 : -1;
    }

    public static int checkString(String s, int min) {
        if (s == null || s.trim().length() < min) {
            return -1;
        }
        return 0;
    }

    public static int checkNumber(int value, int min) {
        if (value < min) {
            return -1;
        }
        return 0;
    }

    public static int checkNumber(double value, double min) {
        if (value < min) {
            return -1;
        }
        return 0;
    }

    public static LocalDateTime convertStringToDateTime(String s, DateTimeFormatter formatter)
            throws GeneralDateTimeException {
        try {
            return LocalDateTime.parse(s, formatter);
        } catch (NullPointerException e) {
            throw new GeneralDateTimeException("HEMOS RECIBIDO UN NULL EN LUGAR DE UNA FECHA");
        } catch (DateTimeParseException e) {
            throw new GeneralDateTimeException("ERROR AL PARSEAR FECHA: " + e.getMessage());
        } catch (Exception e) {
            throw new GeneralDateTimeException("ERROR INESPERADO: " + e);
        }
    }

    public static LocalDate convertStringToDate(String s, DateTimeFormatter formatter) throws GeneralDateTimeException {
        try {
            return LocalDate.parse(s, formatter);
        } catch (NullPointerException e) {
            throw new GeneralDateTimeException("HEMOS RECIBIDO UN NULL EN LUGAR DE UNA FECHA");
        } catch (DateTimeParseException e) {
            throw new GeneralDateTimeException("ERROR AL PARSEAR FECHA: " + e.getMessage());
        } catch (Exception e) {
            throw new GeneralDateTimeException("ERROR INESPERADO: " + e);
        }
    }
}
