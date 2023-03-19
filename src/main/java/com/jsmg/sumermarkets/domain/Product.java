package com.jsmg.sumermarkets.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jsmg.sumermarkets.dto.ProductDTO;
import lombok.*;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameProduct;
    private String contentProduct;
    private String description;
    private BigDecimal price;
    private Integer existence;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private Supplier supplierId;

    public Product (ProductDTO productDTO){
        BeanUtils.copyProperties(productDTO,this);
    }

}
