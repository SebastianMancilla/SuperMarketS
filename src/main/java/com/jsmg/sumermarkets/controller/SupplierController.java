package com.jsmg.sumermarkets.controller;

import com.jsmg.sumermarkets.domain.Supplier;
import com.jsmg.sumermarkets.service.SupplierService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/supplier")
@AllArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;

    @GetMapping(path = "/")
    public ResponseEntity<List<Supplier>> getSuppliers(){
        return new ResponseEntity<>(supplierService.findAll(), HttpStatus.OK);
    }
}
