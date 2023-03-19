package com.jsmg.sumermarkets.service;

import com.jsmg.sumermarkets.domain.Supplier;
import com.jsmg.sumermarkets.exeption.NoContentExep;
import com.jsmg.sumermarkets.repository.SupplierRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public List<Supplier> findAll(){
        List<Supplier> suppliers = supplierRepository.findAll();
        if(suppliers.isEmpty()){
            throw new NoContentExep("No Hay Proveedores que mostrar");
        }
        return suppliers;
    }
}
