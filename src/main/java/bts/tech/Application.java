package bts.tech;

import javafx.scene.control.cell.ChoiceBoxTreeCellBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner createDummyData(CounterService counterService) {

        return args -> {

            counterService.createCounter();


        };


    }
}
