package com.example.softlearning_springboot.applicationcore.entity.sharedkernel.appservices.serializers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonSerializer<T> implements Serializer<T>{

    private final ObjectMapper mapper=new ObjectMapper();

    @Override
    public String serialize(T object) throws Exception {
        try {
            return this.mapper.writeValueAsString(object);

        } catch (JsonProcessingException e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public T deserialize(String source, Class<T> object) throws Exception {
        try {
            return mapper.readValue(source, object);
        } catch (JsonProcessingException e) {
            throw new Exception(e.getMessage());
        }
    }

}
