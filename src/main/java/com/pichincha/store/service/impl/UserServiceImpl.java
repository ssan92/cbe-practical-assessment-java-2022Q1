package com.pichincha.store.service.impl;

import com.pichincha.store.domain.dto.UserDto;
import com.pichincha.store.repository.UserRepository;
import com.pichincha.store.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public List<UserDto> getAllUsers() {
    return StreamSupport.stream(userRepository.findAll().spliterator(),false)
        .map( user -> UserDto.builder()
            .user(user.getUser())
            .id(user.getId())
            .creationDate(user.getCreationDate())
            .build())
        .collect(Collectors.toList());
  }
}
