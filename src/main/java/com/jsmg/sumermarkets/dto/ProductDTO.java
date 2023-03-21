package com.jsmg.sumermarkets.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jsmg.sumermarkets.domain.Supplier;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@Data
@Builder
@Jacksonized
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String nameProduct;
    private String contentProduct;
    private String description;
    private BigDecimal price;
    private Integer existence;
    private Supplier supplierId;

    @JsonProperty("supplierId")
    private void unpackNested(Long id){
        this.supplierId = new Supplier();
        supplierId.setId(id);
    }

}
