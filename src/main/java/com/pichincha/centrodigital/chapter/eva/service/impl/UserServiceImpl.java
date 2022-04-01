package com.pichincha.centrodigital.chapter.eva.service.impl;

import com.pichincha.centrodigital.chapter.eva.dto.UserDto;
import com.pichincha.centrodigital.chapter.eva.dto.UserRequest;
import com.pichincha.centrodigital.chapter.eva.mapper.UserMapper;
import com.pichincha.centrodigital.chapter.eva.repository.UserRepository;
import com.pichincha.centrodigital.chapter.eva.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserMapper mapper;
  private final UserRepository repository;

  @Override
  public UserDto createUser(UserRequest userRequest) {
    final var shopEntity = mapper.toEntity(userRequest);
    final var savedUser = repository.save(shopEntity);

    return mapper.toDto(savedUser);
  }
}
