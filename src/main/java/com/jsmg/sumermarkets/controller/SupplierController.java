package com.jsmg.sumermarkets.controller;

import com.jsmg.sumermarkets.domain.Supplier;
import com.jsmg.sumermarkets.dto.SupplierDTO;
import com.jsmg.sumermarkets.service.SupplierService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping(path = "/{id}")
    public ResponseEntity<SupplierDTO> getSupplierById(@PathVariable Long id){
        return  new ResponseEntity<>(supplierService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Supplier> createNewSupplier(@RequestBody SupplierDTO supplierDTO){
        return  new ResponseEntity<>(supplierService.save(supplierDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Supplier> editSupplier(@RequestBody SupplierDTO supplierDTO,@PathVariable Long id){
        return new ResponseEntity<>(supplierService.update(supplierDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Supplier> deleteSupplier(@PathVariable Long id){
        supplierService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
