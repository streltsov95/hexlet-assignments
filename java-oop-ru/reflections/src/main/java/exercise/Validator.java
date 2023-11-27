package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class Validator {

    public static List<String> validate(Address address) {
        List<String> notValidFields = new ArrayList<>();

        for (Field field : address.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(NotNull.class)) {
                try {
                    field.setAccessible(true);
                    if (field.get(address) == null) {
                        notValidFields.add(field.getName());
                    }
                    field.setAccessible(false);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return notValidFields;
    }
}
// END
