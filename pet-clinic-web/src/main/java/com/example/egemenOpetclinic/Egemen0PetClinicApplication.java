package com.example.egemenOpetclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.egemenOpetclinic"})
public class Egemen0PetClinicApplication {

    public static void main(String[] args) {
        SpringApplication.run(Egemen0PetClinicApplication.class, args);
    }
}
