package com.example.softlearning_springboot.applicationcore.entity.sharedkernel.domainservices.validations;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.regex.Pattern;

public class Checker {

    // Función para que no retorne nulo
    public static int NotNull(String s) {
        if (s == null)
            return -1;
        return 0;
    }

    // Función para que la String no retorne vacio
    public static int NotNullEmptyString(String s) {
        if (s == null)
            return -1;
        if (s.length() == 0)
            return -2;
        return 0;
    }

    // Función para que no sea negativa
    public static int NotNegative(int n) {
        if (n < 0)
            return -1;
        return 0;
    }

    // Función para que no sea negativa o 0
    public static int NotZeroNegative(int n) {
        if (n <= 0)
            return -1;
        return 0;
    }

    // Función que no tenga 0
    public static int isZeroOfficial(int i) {
        return (i == 0) ? 0 : -1;
    }

    // Función para que el usuario ponga los mismos caracteres en palabra1 que palabra2
    public static boolean minLength(String s, int length) {
        if (s == null) {
            return false;
        }
        return s.trim().length() >= length;
    }

    // Función que no sea negativo
    public static int nonNegative(int s) {
        return (s < 0) ? -1 : 0;
    }

    // Función que comprueba si es cero
    public static int isZero(int s) {
        return (s == 0) ? 0 : -1;
    }

    // Función que comprueba si es cero o negativo
    public static int nonZeroOrNegative(int error) {
        return error + isZero(error) + nonNegative(error);
    }

    // Función que comprueba que tiene que tener el mínimo valor que pone el usuario
    public static int minValue(int i, int value) {
        return (i < value) ? -3 : 0;
    }

    // Comprueba si la cadena contiene espacios
    public static boolean hasSpaces(String input) {
        if (input == null) {
            return false; // Manejar null devolviendo false
        }
        return input.contains(" ");
    }

    // Función que comprueba si es un número entero
    public static boolean isInt(Object i) {
        return i instanceof Integer;
    }

    // Función que comprueba si es un número entero positivo
    public static boolean isPositiveInt(int i) {
        return isInt(i) && i > 0;
    }

    // Función que comprueba si es un número entero negativo
    public static boolean isNegativeInt(int i) {
        return isInt(i) && i < 0;
    }

    // Función que comprueba si contiene espacios
    public static boolean isNotEmptyTrim(String s) {
        return s != null && s.trim().length() > 0;
    }

    // Función que comprueba si tiene el formato correcto con @ y .
    public static boolean isValidEmailFormat(String s) {
        return s != null && s.contains("@") && s.contains(".");
    }

    // Función para eliminar espacios en medio
    public static String removeSpaces(String input) {
        return (input != null) ? input.replaceAll(" ", "") : null;
    }

    // Función para verificar si una contraseña cumple con la longitud mínima
    public static int PasswordMinLength(String password, int minLength) {
        if (password == null) {
            return -1; 
        }
        if (password.length() < minLength) {
            return -1; 
        }
        return 0; 
    }

    // Obtener mensaje de error
    public static String getErrorMessage(int e) {
        switch (e) {
            case 0:
                return "Done";
            case -1:
                return "Null";
            case -2:
                return "Empty";
            case -3:
                return "Short";
            case -4:
                return "Is Negative";
            case -5:
                return "Non Zero";
            case -6:
                return "Is Not Empty";
            case -7:
                return "Non Negative";
            case -8:
                return "Is Valid Email Format";
            case -9:
                return "Has Spaces";
            case -10:
                return "Bad ISBN";
            case -11:
                return "Bad Date Publicated";
            case -12:
                return "Bad Date Disponibility";
            case -13:
                return "Bad Format Date";
            case -14:
                return "It's not empty trim";
            case -15:
                return "It's Zero";
            case -16:
                return "Min Length";
            default:
                return "Unknown Error";
        }
    }

    // Validamos el email
    public static int validarEmail(String email) {
        // Verifica que el email tenga al menos un carácter antes y después de la '@'
        if (email == null || !email.contains("@") || email.indexOf('@') == 0
                || email.indexOf('@') == email.length() - 1) {
            return -1; 
        }
        String[] partes = email.split("@");
        String dominio = partes[1];
        // Verifica que el dominio tenga al menos un punto
        return dominio.contains(".") ? 0 : -1; 
    }

    // Método para validar un DNI
    public static int validarDNI(String DNI) {
        return (DNI != null && DNI.matches("^\\d{8}[a-zA-Z]$")) ? 0 : -1; 
    }

    // Método para validar un ISBN
    public static int validarISBN(String ISBN) {
        return (ISBN != null && ISBN.matches("^(978|979)\\d{10}$")) ? 0 : -1; 
    }

    public static LocalDateTime checkDateTime(String data) throws DateException {
        // Verifica el formato de fecha y hora en 'dd/mm/yyyy hh:mm:ss'
        if (data == null
                || !Pattern.matches("^(\\d{4})([-/])(\\d{2})([-/])(\\d{2})(\\s)(\\d{2}):(\\d{2}):(\\d{2})$", data)) {
            throw new DateException("Invalid date/time format: " + data); 
        }

        String[] partes = data.split("[-/ :]");
        int dias = Integer.parseInt(partes[2]); // Día.
        int mes = Integer.parseInt(partes[1]); // Mes.
        int año = Integer.parseInt(partes[0]); // Año.
        int horas = Integer.parseInt(partes[3]); // Horas.
        int minutos = Integer.parseInt(partes[4]); // Minutos.
        int segundos = Integer.parseInt(partes[5]); // Segundos.

        // Validación de mes
        if (mes < 1 || mes > 12) {
            throw new DateException("Bad month: " + mes);
        }

        int[] diasPorMes = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int max_dias = diasPorMes[mes - 1];

        // Validación de año bisiesto
        if (mes == 2 && (año % 4 == 0 && (año % 100 != 0 || año % 400 == 0))) {
            max_dias++;
        }

        // Validación de días
        if (dias < 1 || dias > max_dias) {
            throw new DateException("Bad Day: " + dias);
        }

        // Validación de horas, minutos y segundos
        if (horas < 0 || horas > 23) {
            throw new DateException("Bad Hour: " + horas);
        }

        if (minutos < 0 || minutos > 59) {
            throw new DateException("Bad Minutes: " + minutos);
        }

        if (segundos < 0 || segundos > 59) {
            throw new DateException("Bad Seconds: " + segundos);
        }

        // Crear y devolver un objeto LocalDateTime
        return LocalDateTime.of(año, mes, dias, horas, minutos, segundos);
    }

    public static LocalDateTime checkDateTimes(String data) throws DateException{
        try {
            // Verifica si data es nula
            if (data == null) {
                throw new DateException("Invalid date/time format: " + data);
            }
    
            // Verifica el formato de fecha y hora en 'dd/mm/yyyy hh:mm:ss'
            if (!Pattern.matches("^(\\d{2})([-/])(\\d{2})([-/])(\\d{4})(\\s)(\\d{2}):(\\d{2}):(\\d{2})$", data)) {
                throw new DateException("Invalid date/time format: " + data); 
            }
    
            String[] partes = data.split("[-/ :]"); 
            int dias = Integer.parseInt(partes[0]); // Día.
            int mes = Integer.parseInt(partes[1]); // Mes.
            int año = Integer.parseInt(partes[2]); // Año.
            int horas = Integer.parseInt(partes[3]); // Horas.
            int minutos = Integer.parseInt(partes[4]); // Minutos.
            int segundos = Integer.parseInt(partes[5]); // Segundos.
    
            // Validación de mes
            if (mes < 1 || mes > 12) {
                throw new DateException("Bad month: " + mes);
            }
    
            int[] diasPorMes = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
            int max_dias = diasPorMes[mes - 1];
    
            // Validación de año bisiesto
            if (mes == 2 && (año % 4 == 0 && (año % 100 != 0 || año % 400 == 0))) {
                max_dias++;
            }
    
            // Validación de días
            if (dias < 1 || dias > max_dias) {
                throw new DateException("Bad Day: " + dias);
            }
    
            // Validación de horas, minutos y segundos
            if (horas < 0 || horas > 23) {
                throw new DateException("Bad Hour: " + horas);
            }
    
            if (minutos < 0 || minutos > 59) {
                throw new DateException("Bad Minutes: " + minutos);
            }
    
            if (segundos < 0 || segundos > 59) {
                throw new DateException("Bad Seconds: " + segundos);
            }
    
            // Crear y devolver un objeto LocalDateTime
            return LocalDateTime.of(año, mes, dias, horas, minutos, segundos); 
        } catch (Exception e) {
            throw new DateException("Invalid date/time format: " + data);
        }
    }
    

    // Método para validar solo una fecha (sin hora)
    public static LocalDate checkDate(String data) throws DateException {
        // Verifica el formato de fecha en 'dd/mm/yyyy'
        if (data == null || !Pattern.matches("^(\\d{4})([-/])(\\d{2})([-/])(\\d{2})$", data)) {
            throw new DateException("Invalid date format: " + data); 
        }

        String[] partes = data.split("[-/]");
        int dias = Integer.parseInt(partes[2]); // Día.
        int mes = Integer.parseInt(partes[1]); // Mes.
        int año = Integer.parseInt(partes[0]); // Año.

        int[] diasPorMes = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int max_dias = diasPorMes[mes - 1]; 

        // Verifica si el mes es válido
        if (mes < 1 || mes > 12) {
            throw new DateException("Bad month: " + mes); 
        }

        // Verifica si es un año bisiesto y ajusta el máximo de días si es necesario
        if (año % 4 == 0 && (año % 100 != 0 || año % 400 == 0)) {
            max_dias++; // Incrementa los días si es bisiesto
        }

        // Verifica si el día es válido
        if (dias < 1 || dias > max_dias) {
            throw new DateException("Bad Day: " + dias); 
        }

        // Crea y devuelve un objeto LocalDate 
        return LocalDate.of(año, mes, dias);
    }

    // Clase personalizada de excepción para manejar errores de fecha
    public static class DateException extends Exception {
        public DateException(String message) {
            super(message); 
        }
    }
}
