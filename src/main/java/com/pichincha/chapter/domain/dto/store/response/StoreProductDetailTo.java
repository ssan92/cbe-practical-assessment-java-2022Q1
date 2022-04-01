package com.pichincha.chapter.domain.dto.store.response;

import com.pichincha.chapter.domain.jpa.Store;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreProductDetailTo {

    public Store store;
    public List<ProductIdNameTo> products;
}
