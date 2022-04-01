package com.miguelmejia.q12022.service.impl;

import com.miguelmejia.q12022.client.ProductsClient;
import com.miguelmejia.q12022.entity.Product;
import com.miguelmejia.q12022.entity.Store;
import com.miguelmejia.q12022.presenter.ProductPresenter;
import com.miguelmejia.q12022.presenter.StorePresenter;
import com.miguelmejia.q12022.repository.ProductRepository;
import com.miguelmejia.q12022.service.ProductService;
import com.miguelmejia.q12022.service.StoreService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private StoreService storeService;

    @Autowired
    private ProductsClient productsClient;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void generateStock(Long id) throws ResponseStatusException {
        Store store = storeService.findById(id);
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

    private Product fromPresenter(ProductPresenter productPresenter) {
        return modelMapper.map(productPresenter, Product.class);
    }

    private ProductPresenter toPresenter(Product product) {
        ProductPresenter productPresenter = modelMapper.map(product, ProductPresenter.class);
        productPresenter.setStorePresenter(StorePresenter.builder().id(product.getStore().getId()).build());
        return productPresenter;
    }
}
