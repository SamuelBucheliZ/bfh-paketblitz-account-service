package ch.bfh.paketblitz;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI() // see http://localhost:8081/swagger-ui/index.html
                .info(new Info().title("Paketblitz Account Service")
                        .description("Sample Project used in BFH AppTrans exercise, see https://github.com/SamuelBucheliZ/bfh-apptrans-exercise")
                        .version("v0.0.1"));
    }
}
