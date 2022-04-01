package com.pichincha.chapter.domain.dto.product.request;

import com.pichincha.chapter.domain.jpa.Product;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ProductTo {

    @NotEmpty(message = "id is required")
    @NotNull(message = "id is required")
    private Long id;

    @NotEmpty(message = "cod is required")
    @NotNull(message = "cod is required")
    private String cod;

    @NotEmpty(message = "name is required")
    @NotNull(message = "name is required")
    private String name;

    @NotEmpty(message = "price is required")
    @NotNull(message = "price is required")
    private Double price;

    @NotEmpty(message = "stock is required")
    @NotNull(message = "stock is required")
    private Integer stock;

    public Product getProduct() {
        return Product.builder().id(getId()).cod(getCod()).name(getName()).price(getPrice()).stock(getStock())
                .build();
    }
}
