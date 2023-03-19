package com.jsmg.sumermarkets.controller;

import com.jsmg.sumermarkets.domain.Product;
import com.jsmg.sumermarkets.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping(path = "/")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }
}
