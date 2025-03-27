package com.example.softlearning_springboot.applicationcore.entity.sharedkernel.appservices.serializers;

import java.util.TreeMap;

import com.example.softlearning_springboot.applicationcore.entity.book.dtos.BookDTO;
import com.example.softlearning_springboot.applicationcore.entity.client.dtos.ClientDTO;
import com.example.softlearning_springboot.applicationcore.entity.course.dtos.CourseDTO;
import com.example.softlearning_springboot.applicationcore.entity.employee.dtos.EmployeeDTO;
import com.example.softlearning_springboot.applicationcore.entity.provider.dtos.ProviderDTO;

public class SerializersCatalog {
    private static TreeMap<Serializers, Serializer> catalog = new TreeMap<>();

    private static void loadCatalog() {
        // AL CREAR EL SERIALITZADOR PASSEM PER CONSTRUCTOR L'OBJECTE AMB QUE ES REALIZARÀ LA SERIALITZACIO
        catalog.put(Serializers.JSON_BOOK, new JacksonSerializer<BookDTO>());
        catalog.put(Serializers.XML_BOOK, new JacksonXmlSerializer<BookDTO>());
        catalog.put(Serializers.JSON_CLIENT, new JacksonSerializer<ClientDTO>());
        catalog.put(Serializers.XML_CLIENT, new JacksonXmlSerializer<ClientDTO>());
        catalog.put(Serializers.JSON_COURSE, new JacksonSerializer<CourseDTO>());
        catalog.put(Serializers.XML_COURSE, new JacksonXmlSerializer<CourseDTO>());
        catalog.put(Serializers.JSON_EMPLOYEE, new JacksonSerializer<EmployeeDTO>());
        catalog.put(Serializers.XML_EMPLOYEE, new JacksonXmlSerializer<EmployeeDTO>());
        catalog.put(Serializers.JSON_PROVIDER, new JacksonSerializer<ProviderDTO>());
        catalog.put(Serializers.XML_PROVIDER, new JacksonXmlSerializer<ProviderDTO>());
    }

    public static Serializer getInstance(Serializers type) {
        if (catalog.isEmpty()) {
            loadCatalog();
        }
        return catalog.get(type);
    }
}
