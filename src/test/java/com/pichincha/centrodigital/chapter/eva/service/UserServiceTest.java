package com.pichincha.centrodigital.chapter.eva.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.pichincha.centrodigital.chapter.eva.dto.UserDto;
import com.pichincha.centrodigital.chapter.eva.dto.UserRequest;
import com.pichincha.centrodigital.chapter.eva.entity.UserEntity;
import com.pichincha.centrodigital.chapter.eva.mapper.UserMapper;
import com.pichincha.centrodigital.chapter.eva.repository.UserRepository;
import com.pichincha.centrodigital.chapter.eva.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

  @Mock
  private UserMapper mapper;

  @Mock
  private  UserRepository repository;

  @InjectMocks
  private UserServiceImpl userService;

  @Test
  void givenUserRequestWhenMapperUserThenReturnUserSaved() {
    when(mapper.toEntity(any())).thenReturn(UserEntity.builder().build());
    when(repository.save(any())).thenReturn(UserEntity.builder().build());
    when(mapper.toDto(any())).thenReturn(UserDto.builder().build());

    final var user = userService.createUser(UserRequest.builder().build());

    assertNotNull(user);
  }
}