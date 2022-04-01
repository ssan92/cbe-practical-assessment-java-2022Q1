package com.example.q12022.service.webclient;

import com.example.q12022.domain.*;
import com.example.q12022.domain.dto.ProductsMockDTO;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class MocksApiClient {

    private final RestTemplate restTemplate;

    private final String URL_LIST_MOCK_CUSTOMERS = "https://mocki.io/v1/c233ab09-964e-4d1d-ac50-3ad5cd4722b4";

    public MocksApiClient() {
        this.restTemplate = new RestTemplate();
    }

    public List<UserStore> loadInitialDataUsersFromMocks() {
        UserStore[] result = restTemplate.getForObject(
                URL_LIST_MOCK_CUSTOMERS,
                UserStore[].class);
        return Arrays.asList(result);
    }
}
