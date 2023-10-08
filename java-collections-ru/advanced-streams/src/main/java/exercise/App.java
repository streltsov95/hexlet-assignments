package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
public class App {
    public static String getForwardedVariables(String content) {
        return Arrays.stream(content.split("\n"))
                .filter(s -> s.startsWith("environment="))
                .flatMap(s -> Arrays.stream(s.split("\"")))
                .flatMap(s -> Arrays.stream(s.split(",")))
                .filter(s -> s.contains("X_FORWARDED_"))
                .map(s -> s.replaceAll("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
    }
}
//END
