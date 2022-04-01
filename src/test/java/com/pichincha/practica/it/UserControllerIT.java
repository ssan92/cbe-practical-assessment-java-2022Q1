package com.pichincha.practica.it;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.pichincha.practica.dto.UserDTO;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIT {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	public void findAll() throws Exception {
		var userDTO = createUserDTO(null, "Gladys Ronquillo");
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/user").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(userDTO)))
				.andExpect(status().isCreated());
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/user")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].name").exists())
			    .andExpect(MockMvcResultMatchers.jsonPath("$.[*].id").isNotEmpty());
	}

	@Test
	public void findById() throws Exception {
		var userDTO = createUserDTO(3L,"Gladys Ronquillo");
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/user").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(userDTO)))
				.andExpect(status().isCreated());
		var findById = mockMvc.perform(get("/api/v1/user/3").accept(MimeTypeUtils.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		var b = objectMapper.readValue(findById.getResponse().getContentAsString(), UserDTO.class);
		assertThat(b.getUser().equalsIgnoreCase("Gladys Ronquillo"));
	}
	
	@Test
	public void save() throws Exception 
	{
		var userDTO = createUserDTO(null,"Angel");
		mockMvc.perform( MockMvcRequestBuilders
	      .post("/api/v1/user")
	      .content(objectMapper.writeValueAsString(userDTO))
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().isCreated())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
	}
	
	@Test
	public void delete() throws Exception 
	{
		var userDTO = createUserDTO(null, "Gladys Ronquillo");
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/user").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(userDTO)))
				.andExpect(status().isCreated());
		var findById = mockMvc.perform(get("/api/v1/user/1").accept(MimeTypeUtils.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		var c = objectMapper.readValue(findById.getResponse().getContentAsString(), UserDTO.class);
		mockMvc.perform( MockMvcRequestBuilders.delete("/api/v1/user/{id}", c.getId()) )
	        .andExpect(status().isAccepted());
	}

	private UserDTO createUserDTO(Long id, String name) {
		UserDTO user = new UserDTO();
		user.setId(id);
		user.setUser(name);
		return user;
	}


}
