package com.example.demo.clinic;

import com.example.demo.clinic.entity.Client;
import com.example.demo.clinic.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ClientService {

    private final ClientRepository clientRepository;

    public List<Product> getClientProducts() {

        Client client = clientRepository.getOne(2L);
        System.out.println(client.getProducts());
        return client.getProducts();

    }

    /*
    [0,0,1,0]
    [0,0,0,0]
    [0,1,0,1]
    [0,1,0,0]
     */
}
