package com.example.softlearning_springboot.applicationcore.entity.orders.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.example.softlearning_springboot.applicationcore.entity.orders.dtos.OrderDetailDTO;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.domainservices.validations.Checker;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.domainservices.validations.Checker.DateException;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.operations.Operation;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.physics.PhysicalData;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.physics.Storable;

// Implements Storable

// FinishDate (esta quitado en el primer GetInstance pero en el segundo no)
// Phone es lo mismo que phoneContact
public class Order extends Operation implements Storable {
    protected int ClientId;
    protected String receiveraddress, receiverPerson;
    protected LocalDateTime paymentDate, deliveryDate; // Date + Hour
    protected Set<String> phoneContact;
    protected ArrayList<OrderDetail> shoppingcart;
    protected PhysicalData orderpackage = null;
    protected OrderStatus status; // Implementar a fechas y setPackageDimensions

    protected Order() {
        this.phoneContact = new HashSet<String>();
        this.shoppingcart = new ArrayList<OrderDetail>();
        this.status = OrderStatus.CREATED;
    }

    // Primer Get Instance Method Campos CheckOperData + ClientId + ReceiverAddress
    // + PhoneContact

    public static Order getInstance(int ClientId, String receiveraddress, String receiverPerson, String phoneContact,
            int reference, String description, String initdate) throws BuildException, DateException {
        Order order = new Order();
        StringBuilder message = new StringBuilder();

        if (!order.setClientId(ClientId)) {
            message.append("Bad Client Id; ");
        }
        if (!order.setReceiveraddress(receiveraddress)) {
            message.append("Bad Receiver Address; ");
        }
        if (!order.setReceiverPerson(receiverPerson)) {
            message.append("Bad Receiver Person;");
        }
        if (!order.setPhoneContact(phoneContact)) {
            message.append("Bad Phone Contact;");
        }

        try {
            order.CheckOperData(reference, description, initdate);
        } catch (BuildException e) {
            message.append("\nFailed to create Operation: ").append(e.getMessage()).append("\n");
        }

        // Si hay errores, lanzamos la excepción BuildException
        if (message.length() > 0) {
            throw new BuildException("Failed to create First Order: " + message.toString());
        }
        return order;
    }

    // Segon GetInstance Method with ALL -> Fechas las añadimos despues en una linea
    public static Order getInstance(int clientId, String receiveraddress, String receiverPerson, int reference,
            String description, String initdate, String paymentDate,
            String deliveryDate,String finishdate, String shoppingcart, String phoneContact, double high, double width,
            double length, double weight, boolean fragile)
            throws BuildException, DateException {
        Order order = new Order();
        StringBuilder message = new StringBuilder();

        if (!order.setClientId(clientId)) {
            message.append("Bad Client Id; ");
        }
        if (!order.setReceiveraddress(receiveraddress)) {
            message.append("Bad Receiver Address; ");
        }
        if (!order.setReceiverPerson(receiverPerson)) {
            message.append("Bad Receiver Person; ");
        }

        if (!order.setPhoneContact(phoneContact)) {
            message.append("Bad Phone Contact; \n");
        }

        if (!order.setPaymentDate(paymentDate)) {
            message.append("Bad Payment Date; ");
        }

        if (!order.setDeliveryDate(deliveryDate)) {
            message.append("Bad Delivery Date; ");
        }

        if (!order.setFinishDate(finishdate)) {
            message.append("Bad Finish date; \n");
        }

        try {
            order.CheckOperData(reference, description, initdate);
        } catch (BuildException e) {
            message.append("Failed to create Operation: ").append(e.getMessage()).append("\n");
        }

        try {
            order.orderpackage = PhysicalData.getInstance(high, width, length, weight, fragile);
        } catch (BuildException ex) {
            message.append("Failed to create Order Package: ").append(ex.getMessage()).append("\n");
        }

        if (shoppingcart != null) {
            try {
                order.setShopCartDetails(shoppingcart);
            } catch (BuildException sh) {
                message.append("Failed to create Shopping Cart: ").append(sh.getMessage()).append("\n");
            }
        }

        // Si hay errores, lanzamos la excepción BuildException
        if (message.length() > 0) {
            throw new BuildException("Failed to create Second Order: " + message.toString());
        }
        return order;
    }

    public int getClientId() {
        return ClientId;
    }

    public boolean setClientId(int clientId) {
        if (Checker.NotNegative(clientId) != 0) {
            return false;
        }
        this.ClientId = clientId;
        return true;
    }

    public String getReceiveraddress() {
        return receiveraddress;
    }

    public boolean setReceiveraddress(String receiveraddress) {
        if (Checker.NotNullEmptyString(receiveraddress) != 0) {
            return false;
        }
        if (!Checker.minLength(receiveraddress, 4)) {
            return false; // Si tiene menos de 4 caracteres devuelve false
        }
        this.receiveraddress = receiveraddress;
        return true;
    }

    public String getReceiverPerson() {
        return receiverPerson;
    }

    public boolean setReceiverPerson(String receiverPerson) {
        if (Checker.NotNullEmptyString(receiverPerson) != 0) {
            return false;
        }
        if (!Checker.minLength(receiverPerson, 4)) {
            return false; // Si tiene menos de 4 caracteres devuelve false
        }
        this.receiverPerson = receiverPerson;
        return true;
    }

    // ----------------- FECHAS ---------------------------- //

    public String getPaymentDate() {
        return paymentDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    // Implementar Order Status de CONFIRMED A FORTHCOMMING
    public boolean setPaymentDate(String paymentDate) throws DateException {
        if (paymentDate != null || this.status == OrderStatus.CONFIRMED) {
            if (Checker.NotNullEmptyString(paymentDate) == 0) {
                LocalDateTime date = Checker.checkDateTimes(paymentDate);
                this.paymentDate = date;
                this.status = OrderStatus.CONFIRMED;
                return true;
            }
        }
        return false;
    }

    public String getDeliveryDate() {
        return deliveryDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    // Implementar Order Status de FORTHCOMMING A DELIVERED
    public boolean setDeliveryDate(String deliveryDate) throws DateException {
        if (deliveryDate != null || this.status == OrderStatus.FORTHCOMMING) {
            if (Checker.NotNullEmptyString(deliveryDate) == 0) {
                LocalDateTime date = Checker.checkDateTimes(deliveryDate);
                this.deliveryDate = date;
                this.status = OrderStatus.DELIVERED;
                return true;
            }
        }
        return false;
    }

    public String getInitdate() {
        return initdate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    // Implementar Order Status --> CREATED --> CONFIRMED
    public boolean setInitDate(String initdate) throws DateException {
        if (initdate != null || this.status == OrderStatus.CREATED) {
            if (Checker.NotNullEmptyString(initdate) == 0) {
                LocalDateTime date = Checker.checkDateTimes(initdate);
                this.initdate = date;
                return true;
            }
        }
        return false;
    }
    

    public String getFinishdate() {
        return finishdate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    // Implementar Order Status --> DELIVERED --> FINISHED
    public boolean setFinishDate(String finishdate) throws DateException {
        if (finishdate != null || this.status == OrderStatus.DELIVERED) {
            if (Checker.NotNullEmptyString(finishdate) == 0) {
                LocalDateTime date = Checker.checkDateTimes(finishdate);
                this.finishdate = date;
                this.status = OrderStatus.FINISHED;
                return true;
            }
        }
        return false;
    }

    // Physical Data (GET + SET) 

    public double getHigh() {
        return orderpackage.getHigh();
    }

    public double getLength() {
        return orderpackage.getLength();
    }

    public double getWeight() {
        return orderpackage.getWeight();
    }

    public double getWidth() {
        return orderpackage.getWidth();
    }

    public boolean getFragile() {
        return orderpackage.getFragile();
    }


    // Datos para saber el volumen (general)

    public double getVolume() {
        return orderpackage.getHigh() * orderpackage.getWidth() * orderpackage.getLength();
    }

    // Get Dimensions con todas las variables (datos juntos)

    public String getPackageDimensions() {
        return "Width: " + orderpackage.getWidth() + "cm\n" + // Ancho
                "Length: " + orderpackage.getLength() + "cm\n" + // Largo
                "High: " + orderpackage.getHigh() + "cm\n" + // Alto
                "Weight: " + orderpackage.getWeight() + "cm\n" + // Peso
                "Fragile: " + orderpackage.getFragile(); // Fragilidad
    }

    // Implementar Order Status aqui tambien
    public void setPackageDimensions(double width, double length, double height, double weight, boolean fragile) throws BuildException {
        String[] keys = { "W", "L", "H", "w", "F" };

        for (int i = 0; i < keys.length; i++) {
            switch (keys[i]) {
                case "W":
                    orderpackage.setWidth(width);
                    break;
                case "L":
                    orderpackage.setLength(length);
                    break;
                case "H":
                    orderpackage.setHigh(height);
                    break;
                case "w":
                    orderpackage.setWeight(weight);
                    break;
                case "F":
                    orderpackage.setFragile(fragile);
                    break;
                default:
                    System.out.println("Dato incorrectisimo.");
                    break;
            }
        }
        this.status=OrderStatus.FORTHCOMMING;
    }

    // HASH SET PHONE CONTACTS (SET + GET + Función para tener un separador con
    // comas)

    public String getPhoneContact() {
        return String.join(",", this.phoneContact);
    }

    public boolean setPhoneContact(String phoneContact) {
        if (Checker.NotNullEmptyString(phoneContact) != 0) {
            return false;
        }
        Set<String> phoneSet = new HashSet<>();
        for (String phone : phoneContact.split(",")) {
            phone = phone.trim();
            if (!Checker.minLength(phone, 9)) {
                return false;
            }
            phoneSet.add(phone);
        }
        this.phoneContact = phoneSet;
        return true;
    }

    // ARRAY LIST (Carrito de Compras --> Gestión)

    // Número de detalles del carrito
    public int getNumDetails() {
        return shoppingcart.size();
    }

    // Añadir un Order Detail a la lista del carrito de la compra
    public void addDetail(OrderDetail orderDetail) {
        shoppingcart.add(orderDetail);
    }

    // Añadir Order Details
    public int setDetail(String reference_id, int amount, int subtotal_price, int discount, String name_product) throws BuildException{
        try {
            OrderDetail orderDetail = OrderDetail.getInstance(reference_id, amount, subtotal_price, discount,
                    name_product);
            addDetail(orderDetail);
            return 0;
        } catch (BuildException ex) {
            System.err.println("Error al crear Order Detail: " + ex.getMessage());
            return -1;
        }
    }

    // Obtener Order Detail por Posición
    public String getDetail(int pos) {
        if (pos >= 0 && pos < shoppingcart.size()) {
            return shoppingcart.get(pos).toString();
        } else {
            return "Posición no encontrada";
        }
    }

    // Obtener Order Detail por Referencia
    public String getDetail(String ref) {
        for (OrderDetail orderDetail : shoppingcart) {
            if (String.valueOf(orderDetail.getReference_id()).equals(ref)) {
                return orderDetail.toString();
            }
        }
        return "Referencia no encontrada";
    }

    // Actualizar detalle por posición
    public boolean updateDetail(int pos, int amount) {
        if (pos >= 0 && pos < shoppingcart.size()) {
            OrderDetail orderDetail = shoppingcart.get(pos);
            orderDetail.setAmount(amount);
            System.out.println("La actualización del producto en la posición " + pos + " se hizo correctamente");
            return true; 
        } else {
            throw new IllegalArgumentException("Error: La posición " + pos + " no es válida.");
        }
    }

    // Actualizar detalle por referencia
    public boolean updateDetail(String ref, int amount) {
        for (OrderDetail orderDetail : shoppingcart) {
            if (String.valueOf(orderDetail.getReference_id()).equals(ref)) {
                orderDetail.setAmount(amount);
                System.out.println("La actualización del producto con referencia " + ref + " se hizo correctamente");
                return true;
            }else{
                throw new IllegalArgumentException("Error: No se encontró un producto con la referencia " + ref);
            }
        }
        return false;
    }

    // Eliminar detalle por posición
    public boolean deleteDetail(int pos) {
        if (pos >= 0 && pos < shoppingcart.size()) {
            shoppingcart.remove(pos);
            System.out.println("El producto en la posición " + pos + " fue eliminado correctamente");
            return true; 
        } else {
            throw new IllegalArgumentException("Error: La posición " + pos + " no es válida");
        }
    }

    // Eliminar detalle por referencia
    public boolean deleteDetail(String ref) {
        for (int i = 0; i < shoppingcart.size(); i++) {
            if (String.valueOf(shoppingcart.get(i).getReference_id()).equals(ref)) {
                shoppingcart.remove(i);
                System.out.println("El producto con referencia " + ref + " fue eliminado correctamente");
                return true; 
            }
        }
        throw new IllegalArgumentException("Error: No se encontró ningún producto con la referencia " + ref + ".");
    }

    // Obtener precio total del carrito
    public double getPriceDiscount() {
        double totalPrice = 0.0;
        double totalDiscount = 0.0;
        for (OrderDetail orderDetail : shoppingcart) {
            double Subtotal = orderDetail.getSubtotal_price() * orderDetail.getAmount();
            double Discount = Subtotal * (orderDetail.getDiscount() / 100.0);

            totalPrice += Subtotal;
            totalDiscount += Discount;
        }
        return totalPrice - totalDiscount;
    }

    public double getPriceNoDiscount() {
        double totalPrice = 0.0;
        for (OrderDetail orderDetail : shoppingcart) {
            double itemSubtotal = orderDetail.getSubtotal_price() * orderDetail.getAmount();
            totalPrice += itemSubtotal;
        }

        return totalPrice;
    }

    // Retornamos una lista del carrito de la compra
    public ArrayList<OrderDetail> getShoppingCart() {
        return new ArrayList<>(shoppingcart);
    }

    // Retornamos una lista del carrito de la compra
    public ArrayList<OrderDetailDTO> getShoppingCartDtos() {
        return new ArrayList<OrderDetailDTO>();
    }

    // Configurar detalles del carrito de compras SET
    public void setShopCartDetails(String shoppingcart) throws BuildException {
        String[] cartDetails = shoppingcart.split(";");
        for (String detailData : cartDetails) {
            String[] detailParts = detailData.split(",");

            if (detailParts.length != 5) {
                throw new BuildException(
                        "Carrito de Compras denegado, esperabamos 5 elementos y se ha obtenido: "
                                + detailParts.length);
            }

            String reference_id = detailParts[0].trim();
            int amount = Integer.parseInt(detailParts[1].trim());
            int subtotal_price = Integer.parseInt(detailParts[2].trim());
            int discount = Integer.parseInt(detailParts[3].trim());
            String name_product = detailParts[4].trim();

            setDetail(reference_id, amount, subtotal_price, discount, name_product);
        }
    }

    // Obtener Order Details del carrito de la compra en String Utilizar tres split
    // -> uno ; otro , y otro por :)
    public String getShopCartDetails() {
        StringBuilder details = new StringBuilder();
        for (OrderDetail detail : shoppingcart) {
            details.append(detail.getName_product()).append(",");
            details.append(detail.getReference_id()).append(",");
            details.append(detail.getAmount()).append(",");
            details.append(detail.getDiscount()).append(",");
            details.append(detail.getSubtotal_price()).append("; ");
        }
        if (details.length() > 0) {
            details.setLength(details.length() - 1);
        }
        return details.toString();
    }

    // ------------------ ORDER STATUS ------------------ //

    /* Poner en este apartado un getStatus y si acaso otro por si esta cancelado */

    public String getStatus() {
        return status.name();
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
    
    public boolean isCancelled() {
        return this.status == OrderStatus.CANCELLED;
    }

    // ------------------- FRASES ------------------------- //

    @Override
    public String toString() {
        return "Order [ClientId=" + ClientId + "]";
    }

    public String getContactData() {
        StringBuilder printData = new StringBuilder("ESTA ES LA INFORMACIÓN DEL ORDER: ");
        printData.append("El id es: ").append(this.ClientId);
        printData.append(", el lugar de entrega es: ").append(this.receiveraddress);
        printData.append(", la persona a la que se le entrega es: ").append(this.receiverPerson);
        printData.append(", el id de referencia de la operación es: ").append(this.getReference());
        printData.append(", la descripción es: ").append(this.getDescription());
        printData.append(", la fecha de inicio es: ").append(this.getInitdate());
        printData.append(", los números de telefonos añadidos son: ").append(this.getPhoneContact());
        printData.append(", el carrito de la compra es: ").append(this.getShopCartDetails());
        return printData.toString();
    }

    public String getDetails() {
        StringBuilder mensaje_order = new StringBuilder();
        mensaje_order.append("ESTO SÓN LOS DETALLES DE LA OPERACIÓN: ");
        mensaje_order.append(" el id es: ").append(this.ClientId);
        mensaje_order.append(", el lugar de entrega es: ").append(this.receiveraddress);
        mensaje_order.append(", la persona a la que se le entrega es: ").append(this.receiverPerson);
        mensaje_order.append(", la fecha de pago es: ")
                .append(this.paymentDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        mensaje_order.append(", la fecha de entrega es: ")
                .append(this.deliveryDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        mensaje_order.append(", el id de referencia de la operación es: ").append(this.getReference());
        mensaje_order.append(", la descripción es: ").append(this.getDescription());
        mensaje_order.append(", la fecha de inicio es: ").append(this.getInitdate());
        mensaje_order.append(", la fecha de finalización es: ").append(this.getFinishdate());
        mensaje_order.append(", el número de telefono añadido es: ").append(this.getPhoneContact());
        mensaje_order.append(", alto: ").append(this.getHigh()).append(" cm");
        mensaje_order.append(", ancho: ").append(this.getWidth()).append(" cm");
        mensaje_order.append(", largo: ").append(this.getLength()).append(" cm");
        mensaje_order.append(", peso: ").append(this.getWeight()).append(" kg");
        mensaje_order.append(", es frágil: ").append(this.getFragile());
        mensaje_order.append(", el carrito de la compra es: ").append(this.getShopCartDetails());
        return mensaje_order.toString();
    }

}
