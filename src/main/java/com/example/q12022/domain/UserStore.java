package com.example.q12022.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@ApiModel("User entity")
@Table(name = "USER_STORE")
public class UserStore {
    @Id
    @ApiModelProperty("User ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @ApiModelProperty("User")
    @Column(name = "user", nullable = false)
    private String user;

    @ApiModelProperty("User creation date")
    @Column(name = "CREATE_AT", nullable = false)
    private Date createAt;

    public UserStore() {
        this.createAt = new Date();
    }
}