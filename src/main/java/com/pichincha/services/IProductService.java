package com.pichincha.services;

import com.pichincha.domains.dto.ProductServiceDto;
import com.pichincha.domains.dto.RequestProductDto;
import com.pichincha.domains.jpa.ProductJpa;
import java.util.List;

public interface IProductService {

  ProductServiceDto getProductService();

  List<ProductJpa> saveProductByIdShop(RequestProductDto requestProductDto);
}
