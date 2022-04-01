package com.evaluation.chapter.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostProduct {

  private Long id;
  private String cod;
  private String name;
  private String price;
  private Long stock;
}
