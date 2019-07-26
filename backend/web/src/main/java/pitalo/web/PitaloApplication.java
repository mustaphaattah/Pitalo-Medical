package pitalo.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"pitalo"})
@EnableJpaRepositories(basePackages = {"pitalo"})
public class PitaloApplication {

    public static void main(String[] args) {
        SpringApplication.run(PitaloApplication.class, args);
    }
}
