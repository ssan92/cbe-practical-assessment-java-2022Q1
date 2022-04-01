package com.evaluation.chapter.webclient;

import com.evaluation.chapter.entity.ProductList;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

@Component
@Log4j2
public class ProductWebClient {

  protected WebClient webClient;

  protected ProductWebClient() {
    this.webClient = WebClient.builder()
        .baseUrl("https://253b6042-ec17-4ee8-8d7d-ea9d62805337.mock.pstmn.io")
        .clientConnector(new ReactorClientHttpConnector(HttpClient.newConnection().compress(true)))
        .build();
  }

  private RequestBodySpec setupWebclient() {
    return (RequestBodySpec) this.webClient
        .get()
        .uri(uriBuilder ->
            uriBuilder.path("/dummy-products").build()
        );
  }

  public Mono<ProductList> getProducts() {
    return setupWebclient()
        .retrieve()
        .bodyToMono(ProductList.class).log();
  }
}
