package com.miguelmejia.q12022.presenter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StorePresenter {
    private long id;
    private String name;
    private String category;
    private UserPresenter userPresenter;
    private List<ProductPresenter> products;
}
