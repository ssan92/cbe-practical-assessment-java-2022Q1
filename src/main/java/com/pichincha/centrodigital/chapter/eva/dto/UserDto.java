package com.pichincha.centrodigital.chapter.eva.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

  private Integer id;
  private String userName;
  private LocalDateTime createTime;

}
