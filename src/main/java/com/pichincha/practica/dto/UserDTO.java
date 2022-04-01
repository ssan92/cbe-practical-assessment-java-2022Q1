package com.pichincha.practica.dto;

import java.time.LocalDateTime;

import com.pichincha.practica.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private Long id;
	private String user;
	private LocalDateTime creationDate = LocalDateTime.now();

	public User toEntity() {
		return new User(id, user,creationDate);
	}

}
