package sk.lukaspatrnciak.informationsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sk.lukaspatrnciak.informationsystem.data.InformationSystem;
import sk.lukaspatrnciak.informationsystem.data.user.service.UserService;
import sk.lukaspatrnciak.informationsystem.data.contract.service.ContractService;

@SpringBootApplication
public class InformationSystemApplication {
    public static void main(String[] args) {
        System.out.println("I N F O R M A C N Y   S Y S T E M   : : I S\n");
        System.out.println("Vytvoril: Lukas Patrnciak\nAIS ID: 92320 (xpatrnciak)\nE-mail: xpatrnciak@stuba.sk\n        lukaspatrnciakk@gmail.com\n");
        System.out.println("    --------------------------------");

        SpringApplication.run(InformationSystemApplication.class, args);

        UserService userService = new UserService();
        ContractService contractService = new ContractService();

        InformationSystem informationSystem = new InformationSystem(userService, contractService);
    }
}