package exercise;

import java.nio.file.Path;
import java.nio.file.Files;

// BEGIN
class App {
    public static void save(Path path, Car car) throws Exception {
        String jsonRepresentation = car.serialize();
        Files.writeString(path, jsonRepresentation);
    }

    public static Car extract(Path path) throws Exception {
        String content = Files.readString(path);
        return Car.unserialize(content);
    }
}
// END
