package esprit.se.fennira_mohsen_examen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableScheduling
@SpringBootApplication
public class FenniraMohsenExamenApplication {

    public static void main(String[] args) {
        SpringApplication.run(FenniraMohsenExamenApplication.class, args);
    }

}
