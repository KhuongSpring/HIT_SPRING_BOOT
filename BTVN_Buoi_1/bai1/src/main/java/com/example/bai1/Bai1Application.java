package com.example.bai1;

import com.example.bai1.controllers.PersonController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Bai1Application {
    static
    PersonController personController;

    public Bai1Application(PersonController personController) {
        this.personController = personController;
    }

    public static void main(String[] args) {
        SpringApplication.run(Bai1Application.class, args);
        personController.personDrive();
    }

}
