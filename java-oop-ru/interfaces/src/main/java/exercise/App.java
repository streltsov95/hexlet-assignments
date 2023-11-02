package exercise;

import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static List<String> buildApartmentsList(List<Home> apartments, int quantity) {
        int i = Math.min(quantity, apartments.size());
        return apartments.stream()
                .sorted(Home::compareTo)
                .map(Home::toString)
                .collect(Collectors.toList())
                .subList(0, i);
    }
}
// END
