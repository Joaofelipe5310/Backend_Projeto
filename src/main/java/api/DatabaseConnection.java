package api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatabaseConnection {
    public static void main(String[] args) {

        System.out.println("teste testando testado testeiro");
        SpringApplication.run(DatabaseConnection.class, args);
    }
}