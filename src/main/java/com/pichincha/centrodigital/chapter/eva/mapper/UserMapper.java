package com.pichincha.centrodigital.chapter.eva.mapper;

import com.pichincha.centrodigital.chapter.eva.dto.UserDto;
import com.pichincha.centrodigital.chapter.eva.dto.UserRequest;
import com.pichincha.centrodigital.chapter.eva.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

  @Mapping(target = "createTime", expression = "java( java.time.LocalDateTime.now() )")
  UserEntity toEntity(UserRequest userRequest);

  UserDto toDto(UserEntity userEntity);
}
