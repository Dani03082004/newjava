package com.example.softlearning_springboot.applicationcore.entity.sharedkernel.appservices.serializers;

public interface Serializer<T> { 
    public String serialize(T object) throws Exception;
    public T deserialize(String source, Class<T> object) throws Exception;
} 