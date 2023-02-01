package com.example.moviecharacterapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "API for CRUD operation Movies, Character and Franchise.", version = "1.0.0"),
        servers = {@Server(url = "Http://localhost:8080",description = "localhost for Crud operation")})
public class MovieCharacterApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(MovieCharacterApiApplication.class, args);
    }


}
