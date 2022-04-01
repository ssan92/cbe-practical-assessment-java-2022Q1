package com.pichincha.centrodigital.chapter.eva.controller;


import com.pichincha.centrodigital.chapter.eva.dto.UserDto;
import com.pichincha.centrodigital.chapter.eva.dto.UserRequest;
import com.pichincha.centrodigital.chapter.eva.service.UserService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {

  private final UserService service;

  @PostMapping
  public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserRequest userRequest) {
    final var userDto = service.createUser(userRequest);

    return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
  }
}
