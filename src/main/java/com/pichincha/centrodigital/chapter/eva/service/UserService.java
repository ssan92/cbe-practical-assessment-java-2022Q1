package com.pichincha.centrodigital.chapter.eva.service;

import com.pichincha.centrodigital.chapter.eva.dto.UserDto;
import com.pichincha.centrodigital.chapter.eva.dto.UserRequest;

public interface UserService {

  UserDto createUser(UserRequest userRequest);
}
