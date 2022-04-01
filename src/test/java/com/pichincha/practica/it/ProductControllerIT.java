package com.pichincha.practica.it;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.MimeTypeUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pichincha.practica.dto.ProductDTO;
import com.pichincha.practica.dto.StoreDTO;
import com.pichincha.practica.dto.UserDTO;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIT {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	public void findAll() throws Exception {
		var ownerDTO = mockCreateUser();
		var storeDTO = mockCreateStore(ownerDTO.getId());
		var productDTO = createProductDTO(null, "cod-1", "Celular", new BigDecimal(250), 20L, storeDTO.getId());
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/product").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(productDTO)))
				.andExpect(status().isCreated());
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/product")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].name").exists())
			    .andExpect(MockMvcResultMatchers.jsonPath("$.[*].id").isNotEmpty());
	}

	
	private ProductDTO mockCreateUser() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/user").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(createUserDTO("Propietario"))))
				.andExpect(status().isCreated());
		var find = mockMvc.perform(get("/api/v1/user/1").accept(MimeTypeUtils.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		return objectMapper.readValue(find.getResponse().getContentAsString(), ProductDTO.class);
	}
	
	private StoreDTO mockCreateStore(Long ownerId) throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/store").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(createStoreDTO("Tienda 1", "Tecnologia", ownerId))))
				.andExpect(status().isCreated());
		var find = mockMvc.perform(get("/api/v1/store/1").accept(MimeTypeUtils.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		return objectMapper.readValue(find.getResponse().getContentAsString(), StoreDTO.class);
	}

	private ProductDTO createProductDTO(Long id, String cod, String name, BigDecimal price, Long stock, Long storeId) {
		ProductDTO product = new ProductDTO();
		product.setId(id);
		product.setName(name);
		product.setCod(cod);
		product.setPrice(price);
		product.setStock(stock);
		product.setStoreId(storeId);
		return product;
	}
	
	private StoreDTO createStoreDTO(String name, String category, Long ownerId) {
		StoreDTO store = new StoreDTO();
		store.setName(name);
		store.setCategory(category);
		store.setOwnerId(ownerId);
		return store;
	}
	
	private UserDTO createUserDTO(String name) {
		UserDTO user = new UserDTO();
		return user;
	}


}
