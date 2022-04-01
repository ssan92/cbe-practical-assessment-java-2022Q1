package com.pichincha.infraestructura;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 * Entity implementation class for Entity: Users
 *
 */
@Entity
@Getter
@Setter
@Table(name = "users")
public class Users implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id")
    private Integer id;
	
    @Column(name = "user")
    private String user;
    
    @Column(name = "creation_date")
    private Date creationDate;
    
	@Size(max=1)
	@JsonIgnore
	@Column(name = "state")
    private String state;
	
}