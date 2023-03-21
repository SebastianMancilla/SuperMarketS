package com.jsmg.sumermarkets.service;

import com.jsmg.sumermarkets.domain.Product;
import com.jsmg.sumermarkets.dto.ProductDTO;
import com.jsmg.sumermarkets.exeption.BadRequestExep;
import com.jsmg.sumermarkets.exeption.NoContentExep;
import com.jsmg.sumermarkets.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public ProductDTO findById(Long id){
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new BadRequestExep("El id no esta o no exite en la base de datos");
        }
        return ProductDTO.builder()
                .id(product.get().getId())
                .nameProduct(product.get().getNameProduct())
                .contentProduct(product.get().getContentProduct())
                .description(product.get().getDescription())
                .price(product.get().getPrice())
                .existence(product.get().getExistence())
                .supplierId(product.get().getSupplierId())
                .build();
    }

    public Product save(ProductDTO productDTO){
        if(productDTO == null){
            throw new BadRequestExep("Los datos pedidos no estan integrados");
        }

        return  productRepository.save(new Product(productDTO));
    }

    public Product update(ProductDTO dto, Long id){
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new BadRequestExep("El Id ingresado no esta existente en la base de datos");
        }

        ProductDTO productDTO = ProductDTO.builder()
                .id(product.get().getId())
                .nameProduct(dto.getNameProduct())
                .existence(dto.getExistence())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .contentProduct(dto.getContentProduct())
                .supplierId(product.get().getSupplierId())
                .build();


        return productRepository.save(new Product(productDTO));
    }

    public void delete(Long id){
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new NoContentExep("No se ha encontrado al ID");
        }
        productRepository.deleteById(id);
    }
}
