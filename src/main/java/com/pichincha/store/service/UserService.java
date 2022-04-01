package com.pichincha.store.service;


import com.pichincha.store.domain.dto.UserDto;
import java.util.List;

public interface UserService {

  List<UserDto> getAllUsers();

}
