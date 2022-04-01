package com.pichincha.evaluacion.practica.webclient;

import com.pichincha.evaluacion.practica.dto.mock.ProductsDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class ProviderRestApi {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public ProductsDto getProductsByMock() {
        HttpEntity<ProductsDto> httpEntity = new HttpEntity<>(ProductsDto.builder().build());
        ResponseEntity<ProductsDto> responseEntity = restTemplate().exchange(
                "https://253b6042-ec17-4ee8-8d7d-ea9d62805337.mock.pstmn.io/dummy-products",
                HttpMethod.POST,
                httpEntity,
                ProductsDto.class
        );
        return responseEntity.getBody();
    }
}
