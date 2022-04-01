package com.pichincha.chapter.domain.dto.product.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProductToList {
    @NotEmpty
    private List<ProductTo> prods;

    public ProductToList() {
        prods = new ArrayList<>();
    }
}
