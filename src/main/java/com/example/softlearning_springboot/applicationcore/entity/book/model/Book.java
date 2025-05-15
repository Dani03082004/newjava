package com.example.softlearning_springboot.applicationcore.entity.book.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.domainservices.validations.Checker;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.domainservices.validations.Checker.DateException;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.physics.PhysicalData;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.physics.Storable;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.products.Product;

public class Book extends Product implements Storable {
    protected String languages;
    protected String author;
    protected String isbn;
    protected int pages;
    protected LocalDate date_publicated; // Fecha
    protected LocalDateTime date_disponibility; // Fecha + Hora
    protected PhysicalData data;

    protected Book() {
    }

    public static Book getInstance(String nameproduct, int price, String description, String category,
            String languages, String author, String isbn, int pages, String date_publicated, String date_disponibility,
            double high, double width, double length, double weight, boolean fragile)
            throws BuildException, DateException {
        Book bo = new Book();
        StringBuilder message = new StringBuilder();

        if (!bo.setLanguages(languages)) {
            message.append("Bad languages; ");
        }
        if (!bo.setAuthor(author)) {
            message.append("Bad author; ");
        }
        if (!bo.setIsbn(isbn)) {
            message.append("Bad iSBN; ");
        }
        if (!bo.setPages(pages)) {
            message.append("Bad pages; ");
        }

        if (!bo.setDate_publicated(date_publicated)) {
            message.append("Bad publication date; ");
        }

        if (!bo.setDate_disponibility(date_disponibility)) {
            message.append("Bad availability date; ");
        }

        try {
            bo.data = PhysicalData.getInstance(high, width, length, weight, fragile);
        } catch (BuildException e) {
            System.err.println("Failed to create Physical Data: " + e.getMessage());
            message.append("Failed to create Physical Data; ");
        }

        try {
            bo.CheckProductData(nameproduct, price, description, category);
        } catch (BuildException ex) {
            System.err.println("Failed to create Book: " + ex.getMessage());
            message.append("Failed to create Book: " + ex.getMessage() + "; ");
        }

        if (message.length() > 0) {
            throw new BuildException("Failed to create Book: " + message.toString());
        }

        return bo;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean setIsbn(String isbn) {
        if (Checker.NotNullEmptyString(isbn) != 0) {
            return false;
        }
        if (!Checker.minLength(isbn, 13)) {
            return false;
        }
        if (!Checker.maxLength(isbn, 13)) {
            return false;
        }
        this.isbn = isbn;
        return true;
    }

    public LocalDate getDate_publicated() {
        return date_publicated;
    }

    public boolean setDate_publicated(String date_publicated) throws DateException {
        try {
            // Formato que queremos: dd-MM-yyyy
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            this.date_publicated = LocalDate.parse(date_publicated, formatter);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public LocalDateTime getDate_disponibility() {
        return date_disponibility;
    }

    public boolean setDate_disponibility(String date_disponibility) throws DateException {
        try {
            // Formato que queremos: dd-MM-yyyy HH:mm:ss
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            this.date_disponibility = LocalDateTime.parse(date_disponibility, formatter);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getLanguages() {
        return languages;
    }

    public boolean setLanguages(String languages) {
        int nullCheck = Checker.NotNullEmptyString(languages);
        if (nullCheck != 0) {
            return false; //
        }
        if (Checker.hasSpaces(languages)) {
            return false;
        }
        if (!Checker.minLength(languages, 4)) { // Devuelve false si tiene menos de 4 caracteres
            return false;
        }
        this.languages = languages;
        return true;
    }

    public String getAuthor() {
        return author;
    }

    public boolean setAuthor(String author) {
        int nullCheck = Checker.NotNullEmptyString(author);
        if (nullCheck != 0) {
            return false;
        }
        if (!Checker.minLength(author, 4)) {
            return false; // Si tiene menos de 4 caracteres devuelve false
        }
        this.author = author;
        return true;
    }

    public int getPages() {
        return pages;
    }

    public boolean setPages(int pages) {
        if (Checker.NotNegative(pages) != 0) {
            return false;
        }
        if (Checker.minValue(pages, 10) != 0) { // Si tiene menos de 10 paginas, devuelve false
            return false;
        }
        this.pages = pages;
        return true;
    }

    // --------------------------- PHYSICAL DATA
    // ---------------------------------------------- ///////
    // Añadir métodos también SET del Physical Data
    public double getHigh() {
        return data.getHigh();
    }

    public double getLength() {
        return data.getLength();
    }

    public double getWeight() {
        return data.getWeight();
    }

    public double getWidth() {
        return data.getWidth();
    }

    public boolean getFragile() {
        return data.getFragile();
    }

    public double getVolume() {
        return data.getHigh() * data.getWidth() * data.getLength();
    }

    public String getPackageDimensions() {
        return "Ancho: " + data.getWidth() + "cm" +
                ": Largo: " + data.getLength() + "cm" +
                ": Alto: " + data.getHigh() + "cm";
    }

    // Método para obtener la diferencia entre dos fechas
    public String getPeriod() {
        if (date_publicated != null && date_disponibility != null) {
            // Convertimos date_disponibility a LocalDate
            LocalDate endDate = date_disponibility.toLocalDate();
            Period diferenciaPeriodo = Period.between(date_publicated, endDate);
            return String.format("%d days, %d months, %d years",
                    diferenciaPeriodo.getDays(),
                    diferenciaPeriodo.getMonths(),
                    diferenciaPeriodo.getYears());
        }
        return "Bad Get Period";
    }

    // Método para obtener el intervalo etntre dos fechas
    public List<String> getIntervals(int dias) {
        List<String> fechasArray = new ArrayList<>();
        LocalDate fechaHoy = LocalDate.now();
        LocalDate fechaInicio = date_publicated.isAfter(fechaHoy) ? date_publicated : fechaHoy;

        // Convertimos date_disponibility a LocalDate
        LocalDate end = date_disponibility.toLocalDate();

        // Compruebo si la fecha de inicio es anterior a la fecha final
        if (fechaInicio.isAfter(end)) {
            return fechasArray; // Si la fecha de inicio es después de la fecha final, retorno un listado de
                                // fechas vacio
        }

        for (LocalDate date = fechaInicio; !date.isAfter(end); date = date.plusDays(dias)) {
            fechasArray.add(date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        }

        return fechasArray;
    }

    @Override
    public String toString() {
        return "Book [author=" + author + "]";
    }

    public String getContactData() {
        StringBuilder printData = new StringBuilder("ESTA ES LA INFORMACIÓN DEL LIBRO: ");
        printData.append(" su autor o autora es: ").append(this.author);
        printData.append(", el idioma en el que está el libro es: ").append(this.languages);
        printData.append(", su ISBN es: ").append(this.isbn);
        printData.append(", la fecha de publicación es: ")
                .append(this.date_publicated.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        printData.append(", la fecha de disponibilidad es: ")
                .append(this.date_disponibility.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return printData.toString();
    }

    public String getDetails() {
        StringBuilder printDetails = new StringBuilder("ESTA ES LA INFORMACIÓN DEL LIBRO: ");
        printDetails.append(" el nombre del libro: ").append(this.nameproduct);
        printDetails.append(", el precio correspondiente del libro es: ").append(this.price).append("€");
        printDetails.append(", la descripción es: ").append(this.description);
        printDetails.append(", su marca es: ").append(this.category);
        printDetails.append(", es frágil: ").append(this.getFragile());
        printDetails.append(", alto: ").append(this.getHigh()).append(" cm");
        printDetails.append(", ancho: ").append(this.getWidth()).append(" cm");
        printDetails.append(", largo: ").append(this.getLength()).append(" cm");
        printDetails.append(", peso: ").append(this.getWeight()).append(" kg");
        printDetails.append(", su autor o autora es: ").append(this.author);
        printDetails.append(", el idioma en el que está el libro es: ").append(this.languages);
        printDetails.append(", su ISBN es: ").append(this.isbn);
        printDetails.append(", la fecha de publicación es: ")
                .append(this.date_publicated.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        printDetails.append(", la fecha de disponibilidad es: ")
                .append(this.date_disponibility.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return printDetails.toString();
    }
}
