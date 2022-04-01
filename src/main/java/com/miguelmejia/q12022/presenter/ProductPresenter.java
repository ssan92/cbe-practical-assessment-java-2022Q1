package com.miguelmejia.q12022.presenter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductPresenter {
    private long id;
    private String cod;
    private String name;
    private double price;
    private long stock;
    private StorePresenter storePresenter;
}
