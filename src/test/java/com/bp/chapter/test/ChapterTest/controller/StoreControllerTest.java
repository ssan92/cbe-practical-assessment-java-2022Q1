package com.bp.chapter.test.ChapterTest.controller;

import com.bp.chapter.test.ChapterTest.model.response.DataResponse;
import com.bp.chapter.test.ChapterTest.model.response.headerApp;
import com.bp.chapter.test.ChapterTest.request.StoreRequest;
import com.bp.chapter.test.ChapterTest.request.UserRequest;
import com.bp.chapter.test.ChapterTest.service.StoreService;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.GsonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class StoreControllerTest {

    @InjectMocks
    private StoreController storeController;

    @Mock
    private StoreService storeService;

    private StoreRequest storeRequest;

    private UserRequest userRequest;

    private DataResponse dataResponse;

    MockMvc mvc;

    @BeforeEach
    void setUp() {

        mvc = MockMvcBuilders.standaloneSetup(storeController).build();

        userRequest = new UserRequest();

        storeRequest = new StoreRequest();
        storeRequest.setCategory("category");
        storeRequest.setDirection("dir");
        storeRequest.setIdentifier("ident");
        storeRequest.setName("name");
        storeRequest.setUser(userRequest);

        dataResponse = new DataResponse();
        headerApp header = new headerApp(200, "Se inserto correctamente");
        dataResponse.setHeaderApp(header);

    }

    @Test
    void whenCreateStoreIsExcep() throws Exception {
        storeRequest = new StoreRequest();
        Gson gson = new Gson();
        String jsonInString = gson.toJson(storeRequest);
        headerApp header = new headerApp(400, "Error");
        dataResponse.setHeaderApp(header);
        when(storeService.fnCreateStore(storeRequest)).thenReturn(dataResponse);
        mvc.perform(post("/store/create")
                        .content(jsonInString)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().is4xxClientError());
    }


    @Test
    void whenCreateStoreIsCorrect() throws Exception {

        Gson gson = new Gson();
        String jsonInString = gson.toJson(storeRequest);
        when(storeService.fnCreateStore(any())).thenReturn(dataResponse);
        mvc.perform(post("/store/create")
                        .content(jsonInString)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().is2xxSuccessful());
    }
}