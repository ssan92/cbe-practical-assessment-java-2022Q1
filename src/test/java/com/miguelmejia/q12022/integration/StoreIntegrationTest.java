package com.miguelmejia.q12022.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:integration.yml")
public class StoreIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldSaveNewStoreToInitialUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/store")
                        .contentType(MediaType.APPLICATION_JSON).content("{\n" +
                                "    \"id\": \"1\",\n" +
                                "    \"name\": \"First Store\",\n" +
                                "    \"category\": \"First Category\",\n" +
                                "    \"userPresenter\": {\n" +
                                "        \"id\": \"1\"\n" +
                                "    }\n" +
                                "}"))
                .andExpect(status().isOk());
    }
}
