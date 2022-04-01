package com.pichincha.store.service.mapper;

import com.pichincha.store.domain.Store;
import com.pichincha.store.domain.User;
import com.pichincha.store.domain.dto.StoreDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StoreMapper {

  public StoreDto toDto(Store store){
    return StoreDto.builder()
        .id(store.getId())
        .category(store.getCategory())
        .name(store.getName())
        .owner(store.getOwner().getId())
        .build();
  }

  public Store fromDto(StoreDto store){
    return Store.builder()
        .id(store.getId())
        .category(store.getCategory())
        .name(store.getName())
        .owner(User.builder().id(store.getOwner()).build())
        .build();
  }


}
