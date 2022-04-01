package com.evaluation.chapter.service;

import com.evaluation.chapter.domain.PostProduct;
import com.evaluation.chapter.entity.Product;
import com.evaluation.chapter.entity.Store;
import com.evaluation.chapter.entity.User;
import com.evaluation.chapter.mapper.ProductMapper;
import com.evaluation.chapter.repository.ProductRepository;
import com.evaluation.chapter.repository.StoreRepository;
import com.evaluation.chapter.repository.UserRepository;
import com.evaluation.chapter.webclient.ProductWebClient;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.scheduler.Schedulers;

@Service
@Log4j2
public class ProductService {

  @Autowired
  ProductRepository productRepository;

  @Autowired
  ProductWebClient productWebClient;

  @Autowired
  StoreRepository storeRepository;

  @Autowired
  UserRepository userRepository;

  @Autowired
  ProductMapper productMapper;

  public void createService(PostProduct postProduct, String userId) {
    User user = userRepository.findById(Long.valueOf(userId))
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT));

    Store store = storeRepository.findById(user.getStore().getId())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT));

    Product product = productMapper.postProductToProduct(postProduct);
    product.setProductStore(store);

    productRepository.save(product);
  }

  public void createMockProducts(String store) {
    productWebClient.getProducts()
        .map(productList -> {
          Store store1 = storeRepository.findById(Long.valueOf(store))
              .orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT));

          storeRepository.save(store1);

          productList.getProds().forEach(product -> {
            if (product.getStock() > 5) {
              product.setProductStore(store1);
              productRepository.save(product);
            }
          });

          return productList;
        })
        .subscribeOn(Schedulers.boundedElastic())
        .subscribe();
  }

  public Product getProduct(String id) {
    return productRepository.findById(Long.valueOf(id)).orElse(new Product());
  }
}
