package me.medelhimar.customerservice;

import me.medelhimar.customerservice.entities.Customer;
import me.medelhimar.customerservice.repository.CustomerRepository;
import me.medelhimar.customerservice.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CustomerRepository customerRepository, CustomerService customerService) {
        return args -> {
            List<String> names = List.of("Mohammed", "Amal", "Amine");
            names.forEach(name -> {
                Customer c = Customer.builder()
                        .name(name)
                        .email(name + "@gmail.com")
                        .build();
                customerService.saveCustomer(c);
            });
        };
    }
}
