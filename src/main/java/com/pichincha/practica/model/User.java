package com.pichincha.practica.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.pichincha.practica.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class User extends Base {
	
	@Column(name = "usuario")
	private String user;
	
	public User(Long id, String user, LocalDateTime creationDate) {
		this.id = id;
		this.user = user;
		this.creationDate = creationDate;
	}
	
	public UserDTO toDTO() {
		return new UserDTO(id, user, creationDate);
	}
}
