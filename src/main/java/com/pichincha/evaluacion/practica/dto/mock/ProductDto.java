package com.pichincha.evaluacion.practica.dto.mock;

import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ProductDto {
    private Long id;
    private String cod;
    private String name;
    private BigDecimal price;
    private BigInteger stock;
}
