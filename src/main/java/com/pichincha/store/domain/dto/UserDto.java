package com.pichincha.store.domain.dto;

import static lombok.AccessLevel.PRIVATE;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = PRIVATE)
public class UserDto {
  Long id;
  String user;
  Date creationDate;
}