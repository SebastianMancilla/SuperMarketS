package com.jsmg.sumermarkets.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.jsmg.sumermarkets.dto.SupplierDTO;
import lombok.*;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Supplier")
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Supplier{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameSupplier;
    private String addressSupplier;
    private String phoneSupplier;
    private String mailAddress;
    @JsonManagedReference
    @OneToMany(mappedBy = "supplierId")
    private List<Product> products;

    public Supplier (SupplierDTO supplierDTO){
        BeanUtils.copyProperties(supplierDTO, this);
    }
}
