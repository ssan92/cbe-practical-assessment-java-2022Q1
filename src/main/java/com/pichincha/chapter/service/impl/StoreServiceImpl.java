package com.pichincha.chapter.service.impl;

import com.pichincha.chapter.domain.dto.product.request.ProductToList;
import com.pichincha.chapter.domain.jpa.Product;
import com.pichincha.chapter.domain.jpa.Store;
import com.pichincha.chapter.domain.jpa.StoreProduct;
import com.pichincha.chapter.exception.StoreAdministrationException;
import com.pichincha.chapter.repository.StoreProductRepository;
import com.pichincha.chapter.repository.StoreRepository;
import com.pichincha.chapter.service.ProductService;
import com.pichincha.chapter.service.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class StoreServiceImpl implements StoreService {

    private static final String URL_MOCK_PRODUCTS_API = "https://253b6042-ec17-4ee8-8d7d-ea9d62805337.mock.pstmn.io/dummy-products";

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private StoreProductRepository storeProductRepository;

    @Override
    public Store saveStore(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public Store getStoreByName(String name) {
        return storeRepository.findByName(name).stream().findFirst()
                .orElseThrow(() -> new StoreAdministrationException("Store with name " + name + " not founded."));
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
            throw new StoreAdministrationException("Store with cod " + store.getCod() + " not founded.");
        }
    }

    @Override
    public void deleteStoreWithoutProducts(Long codStore) {

    }

    @Override
    @Transactional
    public void assignProductsToStore(Long codStore) {
        Optional<Store> storeOptional = storeRepository.findById(codStore);
        if (storeOptional.isPresent()) {
            List<StoreProduct> listStoreProduct = storeProductRepository.findByStore(storeOptional.get());
            listStoreProduct.forEach(itemStoreProduct -> storeProductRepository.delete(itemStoreProduct));
            this.saveAndAssignProductsToStore(storeOptional.get());
        } else {
            throw new StoreAdministrationException("Store with cod " + codStore + " not founded.");
        }
    }

    private void saveAndAssignProductsToStore(Store store) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ProductToList> response = restTemplate.getForEntity(URL_MOCK_PRODUCTS_API,
                ProductToList.class);
        ProductToList productToList = response.getBody();
        productToList.getProds().forEach(itemProduct -> {

            if (itemProduct.getStock() > 5) {
                log.info("Save product");
                Product product = productService.saveProduct(itemProduct.getProduct());
                assignAndSaveProductsToStore(store, product);
            }

        });
    }

    private StoreProduct assignAndSaveProductsToStore(Store store, Product product) {
        StoreProduct storeProduct = new StoreProduct();
        storeProduct.setProduct(product);
        storeProduct.setStore(store);
        return storeProductRepository.save(storeProduct);
    }

}
