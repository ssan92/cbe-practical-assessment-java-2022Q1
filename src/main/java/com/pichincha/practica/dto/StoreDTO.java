package com.pichincha.practica.dto;

import java.time.LocalDateTime;

import com.pichincha.practica.model.Store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StoreDTO {

	private Long id;
	private String name;
	private String category;
	private Long ownerId;
	private LocalDateTime creationDate = LocalDateTime.now();

	public Store toEntity() {
		return new Store(id, name, category, ownerId,  creationDate);
	}

}
