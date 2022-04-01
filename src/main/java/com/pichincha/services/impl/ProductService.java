package com.pichincha.services.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pichincha.domains.dto.ProductServiceDto;
import com.pichincha.domains.dto.RequestProductDto;
import com.pichincha.domains.exceptions.InternalErrorException;
import com.pichincha.domains.jpa.ProductJpa;
import com.pichincha.domains.jpa.ShopJpa;
import com.pichincha.domains.mappers.ServiceMapper;
import com.pichincha.respositories.IProductRepository;
import com.pichincha.services.IProductService;
import com.pichincha.services.IShopService;
import com.pichincha.utils.ApiUtilsService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProductService implements IProductService {

  private final ApiUtilsService apiUtilsService;
  private final ServiceMapper serviceMapper;
  private final IProductRepository productRepository;
  private final IShopService iShopService;
  private final Environment environment;
  ObjectMapper objectMapper = new ObjectMapper().configure(
      DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


  @Override
  public ProductServiceDto getProductService() {
    try {
      String url = environment.getRequiredProperty("integration.product.url");
      String consume = apiUtilsService.consumeApi(url, null, HttpMethod.GET,
          ParameterizedTypeReference.forType(String.class), null);
      log.info("Service response", consume);

      return objectMapper.readValue(consume, ProductServiceDto.class);
    } catch (Exception exception) {
      log.error("Error getting product service");
      throw new InternalErrorException();
    }
  }

  @Override
  public List<ProductJpa> saveProductByIdShop(RequestProductDto requestProductDto) {
    ShopJpa shopJpa = iShopService.getShop(requestProductDto.getIdShop());
    List<ProductJpa> products = new ArrayList<>();
    getProductService().getProds().forEach(prodDto -> {
      if (prodDto.getStock() > 5) {
        products.add(serviceMapper.toProductJpa(prodDto, shopJpa));
      }
    });

    productRepository.saveAll(products);
    return products;
  }
}
