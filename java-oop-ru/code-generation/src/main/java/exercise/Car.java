package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// BEGIN
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize() {
        Map<String, Object> userProperties = new HashMap<>();
        Map<String, Object> carProperties = new HashMap<>();
        userProperties.put("id", owner.getId());
        userProperties.put("firstName", owner.getFirstName());
        userProperties.put("lastName", owner.getLastName());
        userProperties.put("age", owner.getAge());
        carProperties.put("id", getId());
        carProperties.put("brand", getBrand());
        carProperties.put("model", getModel());
        carProperties.put("color", getColor());
        carProperties.put("owner", userProperties);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(carProperties);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static Car unserialize(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Map<String, Object> carProperties = objectMapper.readValue(jsonString, Map.class);
            return objectMapper.convertValue(carProperties, Car.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // END
}
