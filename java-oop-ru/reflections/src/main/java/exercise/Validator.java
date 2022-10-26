package exercise;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

// BEGIN
public class Validator {

    public static List<String> validate(Address address) {
        Field[] fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
        }
        return Arrays.stream(fields)
                .filter(field -> field.isAnnotationPresent(NotNull.class))
                .filter(fieldNullValue -> {
                    try {
                        return fieldNullValue.get(address) == null;
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                })
                .map(Field::getName)
                .collect(Collectors.toList());
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        Field[] fields = address.getClass().getDeclaredFields();
        Map<String, List<String>> result = new HashMap<>();
        for (Field field : fields) {
            field.setAccessible(true);
        }
        try {
            for (Field field : fields) {
                List<String> errorDescription = new ArrayList<>();
                if (field.isAnnotationPresent(NotNull.class) && field.get(address) == null) {
                    errorDescription.add("can not be null");
                    result.put(field.getName(), errorDescription);
                }
                if (field.isAnnotationPresent(MinLength.class)) {
                    int minLength = field.getAnnotation(MinLength.class).minLength();
                    if (field.get(address) == null) {
                        errorDescription.add(String.format("length less than %s", minLength));
                        result.put(field.getName(), errorDescription);
                    } else if (field.get(address).toString().length() < minLength) {
                        errorDescription.add(String.format("length less than %s", minLength));
                        result.put(field.getName(), errorDescription);
                    }
                }
            }
        }
        catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
// END
