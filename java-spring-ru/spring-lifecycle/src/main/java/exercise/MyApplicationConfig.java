package exercise;

import java.time.LocalDateTime;

import exercise.daytimes.Daytime;
import exercise.daytimes.Morning;
import exercise.daytimes.Day;
import exercise.daytimes.Evening;
import exercise.daytimes.Night;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// BEGIN
@Configuration
public class MyApplicationConfig {

    @Bean
    public Daytime getDaytime() {
        int time = LocalDateTime.now().getHour();
        if (time < 12 && time >= 6) {
            return new Morning();
        } else if (time >= 12 && time < 18) {
            return new Day();
        } else if (time >= 18 && time < 23) {
            return new Evening();
        }
        return new Night();
    }
}
// END
