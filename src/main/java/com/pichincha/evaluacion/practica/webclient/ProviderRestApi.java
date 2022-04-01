package com.pichincha.evaluacion.practica.webclient;

import com.pichincha.evaluacion.practica.dto.mock.ProductsDto;
import com.pichincha.evaluacion.practica.handler.exceptions.BadRequestMatchException;
import com.pichincha.evaluacion.practica.handler.exceptions.GeneralErrorException;
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

    public ProductsDto getProductsByMock() throws GeneralErrorException {
        HttpEntity<ProductsDto> httpEntity = new HttpEntity<>(ProductsDto.builder().build());
        ResponseEntity<ProductsDto> responseEntity = restTemplate().exchange(
                "https://253b6042-ec17-4ee8-8d7d-ea9d62805337.mock.pstmn.io/dummy-products",
                HttpMethod.POST,
                httpEntity,
                ProductsDto.class
        );
        if (responseEntity.getStatusCode().is4xxClientError()){
            throw new BadRequestMatchException();
        }
        if (responseEntity.getStatusCode().is5xxServerError()){
            throw new GeneralErrorException("Error 500");
        }
        return responseEntity.getBody();
    }
}
