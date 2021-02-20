package com.example.demo;

import com.example.demo.clinic.ClientRepository;
import com.example.demo.clinic.ClientService;
import com.example.demo.clinic.entity.Client;
import com.example.demo.clinic.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private ClientService clientService;

    @Override
    public void run(String... args) throws Exception {
        //stworz 1 Klienta (imie, wiek)
        //dodaj do neigo 2 Produkty (nazwa, cena)
        //zapisz lekarza
        //co sie stanie sie?

//        Client client = new Client();
//        client.setName("Pawel");
//        client.setSurname("Kowalik");
//
//        Product product1 = new Product();
//        product1.setName("Notebook");
//        product1.setPrice(3451.23);
//
//        Product product2 = new Product();
//        product2.setName("Mouse");
//        product2.setPrice(45.12);
//
//        client.setProducts(Arrays.asList(product1, product2));
//
//        clientRepository.save(client);

        List<Product> clientProducts = clientService.getClientProducts();

        System.out.println(clientProducts);


    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
