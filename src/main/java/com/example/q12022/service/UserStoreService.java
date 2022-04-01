package com.example.q12022.service;

import com.example.q12022.domain.dto.UserStoreDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserStoreService {

    UserStoreDTO getCustomer(Long id);

    List<UserStoreDTO> getAllCustomers();

    UserStoreDTO saveCustomer(UserStoreDTO dto);

    Long deleteCustomer(Long id);
}
