package exercise;

import exercise.daytime.Day;
import exercise.daytime.Night;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

import exercise.daytime.Daytime;

// BEGIN
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.annotation.RequestScope;
// END

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @Bean
    @RequestScope
    public Daytime getDayTime() {
        var currentHour = LocalDateTime.now().getHour();

        if (currentHour >= 6 && currentHour < 22) {
            return new Day();
        }

        return new Night();
    }
    // END
}
