package com.example.q12022.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreDTO {

    private Long id;
    private String name;
    private String category;
    private Long userStoreId;
}
