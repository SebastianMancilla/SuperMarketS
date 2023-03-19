package com.jsmg.sumermarkets.service;

import com.jsmg.sumermarkets.domain.Product;
import com.jsmg.sumermarkets.exeption.NoContentExep;
import com.jsmg.sumermarkets.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAll(){
        List<Product> products = productRepository.findAll();
        if(products.isEmpty()){
            throw new NoContentExep("No hay Productos para mostrar");
        }
        return products;
    }
}
