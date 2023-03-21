package com.jsmg.sumermarkets.service;

import com.jsmg.sumermarkets.domain.Supplier;
import com.jsmg.sumermarkets.dto.SupplierDTO;
import com.jsmg.sumermarkets.exeption.BadRequestExep;
import com.jsmg.sumermarkets.exeption.NoContentExep;
import com.jsmg.sumermarkets.repository.SupplierRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public SupplierDTO findById(Long id){
        Optional<Supplier> supplier = supplierRepository.findById(id);
        if(supplier.isEmpty()){
            throw new BadRequestExep("El id no se encuentra o no esta existente");
        }
        return SupplierDTO.builder()
                .id(supplier.get().getId())
                .nameSupplier(supplier.get().getNameSupplier())
                .addressSupplier(supplier.get().getAddressSupplier())
                .phoneSupplier(supplier.get().getPhoneSupplier())
                .mailAddress(supplier.get().getMailAddress())
                .products(supplier.get().getProducts())
                .build();
    }

    public Supplier save(SupplierDTO supplierDTO){
        if(supplierDTO.getNameSupplier().isEmpty()){
            throw new BadRequestExep("El dato 'Nombre', es obligatorio");
        }
        if(supplierDTO.getMailAddress().isEmpty()){
            throw new BadRequestExep("El dato 'Corre', es obligatorio");
        }

        return supplierRepository.save(new Supplier(supplierDTO));
    }

    public Supplier update(SupplierDTO dto, Long id){
        Optional<Supplier> supplier = supplierRepository.findById(id);
        if(supplier.isEmpty()){
            throw new BadRequestExep("El id no esta disponible en la base de datos");
        }
        SupplierDTO supplierDTO = SupplierDTO.builder()
                .id(supplier.get().getId())
                .nameSupplier(dto.getNameSupplier())
                .addressSupplier(dto.getAddressSupplier())
                .phoneSupplier(dto.getPhoneSupplier())
                .mailAddress(dto.getMailAddress())
                .products(supplier.get().getProducts())
                .build();

        return  supplierRepository.save(new Supplier(supplierDTO));
    }

    public void delete(Long id){
        Optional<Supplier> supplier = supplierRepository.findById(id);
        if(supplier.isEmpty()){
            throw new BadRequestExep("El id no esta disponible en la base de datos");
        }
        supplierRepository.deleteById(id);
    }
}
