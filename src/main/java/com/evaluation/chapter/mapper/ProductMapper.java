package com.evaluation.chapter.mapper;

import com.evaluation.chapter.domain.PostProduct;
import com.evaluation.chapter.entity.Product;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {

  Product postProductToProduct(PostProduct postProduct);
}
