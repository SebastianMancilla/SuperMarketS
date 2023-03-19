package com.jsmg.sumermarkets.dto;

import com.jsmg.sumermarkets.domain.Supplier;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@Data
@Builder
@Jacksonized
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String nameProduct;
    private String contentProduct;
    private String description;
    private BigDecimal price;
    private Integer existence;
    private Supplier supplierId;

}
