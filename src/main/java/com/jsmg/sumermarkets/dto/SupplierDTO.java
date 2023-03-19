package com.jsmg.sumermarkets.dto;

import com.jsmg.sumermarkets.domain.Product;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Data
@Builder
@Jacksonized
@AllArgsConstructor
public class SupplierDTO {
    private Long id;
    private String nameSupplier;
    private String addressSupplier;
    private String phoneSupplier;
    private String mailAddress;
    private List<Product> products;
}
