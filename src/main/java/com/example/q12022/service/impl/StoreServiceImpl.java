package com.example.q12022.service.impl;

import com.example.q12022.domain.*;
import com.example.q12022.domain.dto.OrderDTO;
import com.example.q12022.domain.dto.ProductDTO;
import com.example.q12022.domain.dto.StoreDTO;
import com.example.q12022.repository.StoreProductRepository;
import com.example.q12022.repository.StoreRepository;
import com.example.q12022.repository.UserStoreRepository;
import com.example.q12022.service.ProductService;
import com.example.q12022.service.StoreService;
import com.example.q12022.service.TransactionDetailService;
import com.example.q12022.service.TransactionService;
import com.example.q12022.service.webclient.MocksApiClient;
import com.example.q12022.utils.Helpers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final UserStoreRepository userStoreRepository;
    private final ProductService productService;
    private final TransactionService transactionService;
    private final TransactionDetailService transactionDetailService;
    private final StoreProductRepository storeProductRepository;
    private MocksApiClient mocksApiClient;

    public StoreServiceImpl(StoreRepository storeRepository, UserStoreRepository userStoreRepository, ProductService productService, TransactionService transactionService, TransactionDetailService transactionDetailService, StoreProductRepository storeProductRepository) {
        this.storeRepository = storeRepository;
        this.userStoreRepository = userStoreRepository;
        this.productService = productService;
        this.transactionService = transactionService;
        this.transactionDetailService = transactionDetailService;
        this.storeProductRepository = storeProductRepository;
        mocksApiClient = new MocksApiClient();
    }


    @Override
    public StoreDTO getStoreByName(String name) {
        return Helpers.modelMapper().map(storeRepository.findByName(name).get(), StoreDTO.class);
    }

    @Override
    public StoreDTO saveStore(StoreDTO dto) {
        Store store = storeRepository.save(Helpers.modelMapper().map(dto, Store.class));
        return Helpers.modelMapper().map(store, StoreDTO.class);
    }

    @Override
    public Long deleteStore(Long id) {
        storeRepository.deleteById(id);
        return id;
    }

    @Override
    public Boolean placeOrder(OrderDTO data) {
        Optional<UserStore> customer = userStoreRepository.findById(data.getCustomerId());
        if (!customer.isPresent())
            throw new IllegalStateException(String.format("Client with id %d does not exist", data.getCustomerId()));

        List<Transaction> transactionList = new ArrayList<>();

        //Here you can save in a list all transactions with their details. If an exception occurs, no DB record is altered
        data.getDetail().forEach(element -> {
            Optional<Store> store = storeRepository.findById(element.getStoreId());
            if (!store.isPresent())
                throw new IllegalStateException(String.format("Store with id %d does not exist", element.getStoreId()));

            Transaction newTransaction = new Transaction();
            newTransaction.setCustomerId(customer.get().getId());
            newTransaction.setStoreId(store.get().getId());
            newTransaction.setDate(new Date());

            element.getDetail().forEach(e -> {
                ProductDTO product = productService.getProduct(e.getProductId());
                if (product == null)
                    throw new IllegalStateException(String.format("Product with id %d does not exist", e.getProductId()));

                if (!productExistsInTheStore(store.get().getId(), product.getId()))
                    throw new IllegalStateException(String.format("Product %s is not sold in store %s", product.getName(), store.get().getName()));

                if (e.getQuantity() == null || Math.abs(e.getQuantity()) < Double.MIN_NORMAL)
                    throw new IllegalStateException(String.format("The quantity of the product %s cannot be less than one unit", product.getName()));

                if (product.getStock() - e.getQuantity() < 0)
                    throw new IllegalStateException(String.format("Unavailable units of product %s ", product.getName()));

                TransactionDetail transactionDetail = new TransactionDetail();
                transactionDetail.setProductId(e.getProductId());
                transactionDetail.setPrice(product.getPrice());
                transactionDetail.setQuantity(e.getQuantity());
                newTransaction.getDetail().add(transactionDetail);
                newTransaction.setTotal(newTransaction.getTotal() + e.getQuantity() * product.getPrice());
            });

            transactionList.add(newTransaction);
        });

        //Here you can store the transactions with their respective details and you can request extra stock.
        transactionList.forEach(element -> {
            Transaction transactionSaved = transactionService.saveTransaction(element);
            element.getDetail().forEach(e -> {
                e.setTransactionId(transactionSaved.getId());
                ProductDTO product = productService.getProduct(e.getProductId());
                transactionDetailService.saveTransactionDetail(e);
                productService.updateStockProduct(product.getId(), product.getStock() - e.getQuantity());
            });
        });

        return Boolean.TRUE;
    }

    @Override
    public Boolean productExistsInTheStore(Long storeId, Long productId) {
        Optional<StoreProduct> result = storeProductRepository.findByStoreIdAndProductId(storeId, productId);
        return result.isPresent();
    }
}