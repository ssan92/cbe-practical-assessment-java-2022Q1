package com.pichincha.chapter.service.impl;

import com.pichincha.chapter.domain.dto.product.request.ProductToList;
import com.pichincha.chapter.domain.dto.store.response.StoreProductDetailTo;
import com.pichincha.chapter.domain.jpa.Store;
import com.pichincha.chapter.exception.StoreAdministrationException;
import com.pichincha.chapter.repository.StoreRepository;
import com.pichincha.chapter.service.ProductService;
import com.pichincha.chapter.service.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Slf4j
@Service
public class StoreServiceImpl implements StoreService {

    private static final String URL_MOCK_PRODUCTS_API = "https://253b6042-ec17-4ee8-8d7d-ea9d62805337.mock.pstmn.io/dummy-products";

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private ProductService productService;

    @Override
    public Store saveStore(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public Store getStoreByName(String name) {
        return storeRepository.findByName(name).stream().findFirst()
                .orElseThrow(() -> new StoreAdministrationException("Store not founded."));
    }

    @Override
    public Store updateStore(Store store) {
        Optional<Store> storeOptional = storeRepository.findById(store.getCod());
        if (storeOptional.isPresent()) {
            storeOptional.get().setCategory(store.getCategory());
            storeOptional.get().setName(store.getName());
            storeOptional.get().setOwner(store.getOwner());
            return storeOptional.get();
        } else {
            throw new StoreAdministrationException("Store not founded.");
        }
    }

    @Override
    public void deleteStoreWithoutProducts(Long codStore) {

    }

    @Override
    public StoreProductDetailTo assignProductsToStore(Long codStore) {
        this.saveAndAssignProductsToStore();
        return new StoreProductDetailTo();
    }


    private void saveAndAssignProductsToStore() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ProductToList> response = restTemplate.getForEntity(URL_MOCK_PRODUCTS_API,
                ProductToList.class);
        ProductToList productToList = response.getBody();
        log.info("productToList" + productToList);
        productToList.getProds().forEach(itemProduct -> {

            if (itemProduct.getStock() > 5) {
                log.info("Save product");
                productService.saveProduct(itemProduct.getProduct());
            }

        });
    }

}
