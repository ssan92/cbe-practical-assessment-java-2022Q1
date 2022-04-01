package com.pichincha.store.controller;

import com.pichincha.store.domain.dto.UserDto;
import com.pichincha.store.service.MvcService;
import com.pichincha.store.service.UserService;
import java.util.List;
import javax.ws.rs.Consumes;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("/all")
  @Consumes("application/json")
  public ResponseEntity<List<UserDto>> getUsers() {
    return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
  }

}
