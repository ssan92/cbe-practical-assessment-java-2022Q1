package com.pichincha.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ApiUtilsService {

  private final RestTemplate restTemplate;

  public <T> T consumeApi(String url, Object body, HttpMethod method,
      ParameterizedTypeReference<T> parameterizedTypeReference, HttpHeaders headers) {
    ResponseEntity<T> response = restTemplate
        .exchange(url, method, new HttpEntity<>(body, headers), parameterizedTypeReference);
    return response.getBody();
  }
}
