package com.jsmg.sumermarkets.controller;

import com.jsmg.sumermarkets.domain.Product;
import com.jsmg.sumermarkets.dto.ProductDTO;
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

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id){
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/")
    public ResponseEntity<Product> createNewProduct(@RequestBody ProductDTO productDTO){
        return new ResponseEntity<>(productService.save(productDTO), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public  ResponseEntity<Product> editProduct(@RequestBody ProductDTO productDTO, @PathVariable Long id){
        return  new ResponseEntity<>(productService.update(productDTO, id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public  ResponseEntity<Product> deleteProduct(@PathVariable Long id){
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
