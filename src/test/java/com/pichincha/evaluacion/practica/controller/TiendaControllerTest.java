package com.pichincha.evaluacion.practica.controller;

import com.pichincha.evaluacion.practica.entity.StoreEntity;
import com.pichincha.evaluacion.practica.service.EvaluationService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class TiendaControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private EvaluationService evaluationService;

    @Test
    void getStores() {
        //GIVEN
        String id = "id";
        List<StoreEntity> storeEntity = new ArrayList<>();
        storeEntity.add(StoreEntity.builder().build());
        //WHEN
        Mockito.when(evaluationService.getStoresList()).thenReturn((List<StoreEntity>) storeEntity);
        //THEN
        mvc.perform(MockMvcRequestBuilders
                        .get("/drawdown/accounts/{identification}", id)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}