package com.pichincha.evaluacion.practica.dto.mock;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ProductsDto {
    private List<ProductDto> product;
}