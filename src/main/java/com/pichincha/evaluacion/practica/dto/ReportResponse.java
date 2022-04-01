package com.pichincha.evaluacion.practica.dto;

import com.pichincha.evaluacion.practica.entity.ProductXUserEntity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ReportResponse {
    private String productName;
    private String storeName;
    private String storeCategory;
    private List<ProductXUserEntity> totalQuantity;
    private List<ProductXUserEntity> totalAmount;
    private boolean companyCreditLine;
}