package com.example.q12022.controller;

import com.example.q12022.domain.Store;
import com.example.q12022.domain.dto.Response;
import com.example.q12022.domain.dto.StoreDTO;
import com.example.q12022.repository.StoreRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class StoreControllerTest {

    @Autowired
    StoreRepository storeRepository;

    @Autowired
    StoreController storeController;

    @Test
    void saveGetStore() {
        ResponseEntity<Response> result = storeController.saveStore(new StoreDTO(1L, "s-1", "Supermaxi", 1L));

        StoreDTO savedStore = (StoreDTO) result.getBody().getAuto();

        Optional<Store> findStore = storeRepository.findById(savedStore.getId());

        assertEquals(savedStore, findStore.get());

        Optional<Store> findStore2 = storeRepository.findById(111L);

        assertEquals(false, findStore2.isPresent());
    }

    @Test
    void deleteStore() {
        ResponseEntity<Response> result = storeController.saveStore(new StoreDTO(1L, "s-1", "Supermaxi", 1L));
        Store savedStore = (Store) result.getBody().getAuto();

        ResponseEntity<Response> result2 = storeController.deleteStore(savedStore.getId());
        Long storeId = (Long) result2.getBody().getAuto();
        assertEquals(savedStore.getId(), storeId);

        Optional<Store> findStore2 = storeRepository.findById(savedStore.getId());
        assertEquals(false, findStore2.isPresent());
    }
}