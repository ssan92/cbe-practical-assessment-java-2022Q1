package com.pichincha.centrodigital.chapter.eva.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pichincha.centrodigital.chapter.eva.dto.ShopDto;
import com.pichincha.centrodigital.chapter.eva.dto.UserDto;
import com.pichincha.centrodigital.chapter.eva.service.ShopService;
import com.pichincha.centrodigital.chapter.eva.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserService userService;

  @MockBean
  private ShopService shopService;

  @Test
  void givenUserRequestWhenCallUserServiceThenReturnUserCreatedResponse() throws Exception {
    when(userService.createUser(any())).thenReturn(UserDto.builder().build());
    final var mockRequest = post("/users")
        .contentType(APPLICATION_JSON_VALUE)
        .content(new ObjectMapper().writeValueAsString(UserDto.builder().build()));

    mockMvc.perform(mockRequest).andExpect(status().is(HttpStatus.CREATED.value())).andReturn();
  }

  @Test
  void givenShopRequestWhenCallShopServiceThenReturnShopCreatedResponse() throws Exception {
    when(shopService.createShop(any())).thenReturn(ShopDto.builder().build());
    final var mockRequest = post("/shops")
        .contentType(APPLICATION_JSON_VALUE)
        .content(new ObjectMapper().writeValueAsString(UserDto.builder().build()));

    mockMvc.perform(mockRequest).andExpect(status().is(HttpStatus.CREATED.value())).andReturn();
  }
}
