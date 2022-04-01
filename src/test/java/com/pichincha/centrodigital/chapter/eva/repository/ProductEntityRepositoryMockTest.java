package com.pichincha.centrodigital.chapter.eva.repository;

import static org.assertj.core.api.Assertions.*;

import com.pichincha.centrodigital.chapter.eva.entity.ProductEntity;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class ProductEntityRepositoryMockTest {

  @Autowired
  private ProductRepository productRepository;

  @Test
  public void whenFindByCategory_thenReturnListProduct() {
    final var product01 = ProductEntity.builder()
        .cod("prod-1")
        .name("prod-name-1")
        .price(BigDecimal.valueOf(5.5))
        .stock(10)
        .build();

    productRepository.save(product01);

    final var products = productRepository.findAll();

    assertThat(products.size()).isEqualTo(1);
  }

}