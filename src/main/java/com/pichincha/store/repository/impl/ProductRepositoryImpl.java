
package com.pichincha.store.repository.impl;


import com.google.gson.Gson;
import com.pichincha.store.configuration.Properties;
import com.pichincha.store.domain.dto.ProductDto;
import com.pichincha.store.repository.ProductRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
@AllArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

  private final Properties properties;

  @Override
  public List<ProductDto> getProducts() {
    Gson gson = new Gson();
    RestTemplate restTemplate = new RestTemplate();

    ResponseEntity ret = restTemplate.exchange(properties.getProductUrl(),
        HttpMethod.GET,
        new HttpEntity<String>(null, new HttpHeaders()),
        String.class);

     return Arrays.asList( gson.fromJson(ret.getBody().toString(), ProductDto[].class));
  }
}
