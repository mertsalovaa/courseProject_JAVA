package app;

import app.seeder.FoodSeeder;
import app.seeder.UserSeeder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner init(UserSeeder seederDb, FoodSeeder foodSeeder) {
        return (args) -> {
            try {
                seederDb.Seeder();
                foodSeeder.Seeder();
            }
            catch(Exception ex) {
                System.out.println("---- problem ------");
            }
        };
    }

}
