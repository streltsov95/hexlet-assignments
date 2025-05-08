package exercise;

import exercise.daytime.Day;
import exercise.daytime.Night;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

import exercise.daytime.Daytime;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

// BEGIN

// END

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @Bean
    @Scope("prototype")
    public Daytime getDayTime() {
        var currentTime = LocalDateTime.now().getHour();
            if (currentTime >= 6 && currentTime < 22) {
                return new Day();
            } else {
                return new Night();
            }
    }
    // END
}
