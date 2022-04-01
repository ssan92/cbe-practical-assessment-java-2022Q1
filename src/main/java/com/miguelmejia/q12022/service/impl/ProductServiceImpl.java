package com.miguelmejia.q12022.service.impl;

import com.miguelmejia.q12022.client.ProductsClient;
import com.miguelmejia.q12022.entity.Product;
import com.miguelmejia.q12022.entity.Store;
import com.miguelmejia.q12022.presenter.ProductPresenter;
import com.miguelmejia.q12022.presenter.StorePresenter;
import com.miguelmejia.q12022.repository.ProductRepository;
import com.miguelmejia.q12022.repository.StoreRepository;
import com.miguelmejia.q12022.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private ProductsClient productsClient;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void generateStock(Long id) throws ResponseStatusException {
        Store store = storeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "No existe la tienda"));
        productsClient.findAllProducts().getProds().stream().filter(productPresenter -> productPresenter.getStock() > 5)
                .forEach(productPresenter -> {
                    Product product = fromPresenter(productPresenter);
                    product.setStore(store);
                    productRepository.save(product);
                });
    }

    @Override
    public List<ProductPresenter> findAll() {
        return productRepository.findAll().stream().map(this::toPresenter).collect(Collectors.toList());
    }

    @Override
    public List<ProductPresenter> findAllByStore(Long storeId) {
        return findAll().stream().filter(productPresenter -> storeId.equals(productPresenter.getStorePresenter().getId())).collect(Collectors.toList());
    }

    private Product fromPresenter(ProductPresenter productPresenter) {
        return modelMapper.map(productPresenter, Product.class);
    }

    private ProductPresenter toPresenter(Product product) {
        ProductPresenter productPresenter = modelMapper.map(product, ProductPresenter.class);
        productPresenter.setStorePresenter(StorePresenter.builder().id(product.getStore().getId()).build());
        return productPresenter;
    }
}
