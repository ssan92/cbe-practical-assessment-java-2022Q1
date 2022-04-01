package com.example.q12022.service.impl;

import com.example.q12022.domain.UserStore;
import com.example.q12022.domain.dto.UserStoreDTO;
import com.example.q12022.repository.UserStoreRepository;
import com.example.q12022.service.UserStoreService;
import com.example.q12022.utils.Helpers;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserStoreServiceImpl implements UserStoreService {

    private final UserStoreRepository userStoreRepository;

    @Override
    public UserStoreDTO getCustomer(Long id) {
        Optional<UserStore> customer = userStoreRepository.findById(id);
        return Helpers.modelMapper().map(customer.get(), UserStoreDTO.class);
    }

    @Override
    public List<UserStoreDTO> getAllCustomers() {
        List<UserStore> userStores = userStoreRepository.findAll();
        List<UserStoreDTO> result = userStores.stream()
                .map(element -> Helpers.modelMapper().map(element, UserStoreDTO.class))
                .collect(Collectors.toList());

        return result;
    }

    @Override
    public UserStoreDTO saveCustomer(UserStoreDTO dto) {
        if (dto.getName() == null || dto.getName().trim().isEmpty())
            throw new IllegalStateException("The customer's name is required");

        if (dto.getDni() == null || dto.getDni().trim().isEmpty())
            throw new IllegalStateException("Customer DNI is required");

        UserStore userStore = userStoreRepository.save(Helpers.modelMapper().map(dto, UserStore.class));
        return Helpers.modelMapper().map(userStore, UserStoreDTO.class);
    }

    @Override
    public Long deleteCustomer(Long id) {
        userStoreRepository.deleteById(id);
        return id;
    }
}
