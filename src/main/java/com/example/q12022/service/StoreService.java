package com.example.q12022.service;

import com.example.q12022.domain.dto.OrderDTO;
import com.example.q12022.domain.dto.StoreDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StoreService {

    StoreDTO getStoreByName(String name);

    StoreDTO saveStore(StoreDTO dto);

    Long deleteStore(Long id);

    Boolean placeOrder(OrderDTO data);

    Boolean productExistsInTheStore(Long storeId, Long productId);
}
