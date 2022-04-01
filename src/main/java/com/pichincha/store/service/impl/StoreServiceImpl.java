package com.pichincha.store.service.impl;

import com.pichincha.store.domain.Store;
import com.pichincha.store.domain.dto.ProductDto;
import com.pichincha.store.domain.dto.StoreDto;
import com.pichincha.store.domain.dto.UserDto;
import com.pichincha.store.domain.enums.StoreStatus;
import com.pichincha.store.repository.ProductRepository;
import com.pichincha.store.repository.StoreRepository;
import com.pichincha.store.repository.UserRepository;
import com.pichincha.store.service.StoreService;
import com.pichincha.store.service.UserService;
import com.pichincha.store.service.mapper.StoreMapper;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.persistence.NoResultException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class StoreServiceImpl implements StoreService {

  private final StoreRepository storeRepository;
  private final UserRepository userRepository;
  private final ProductRepository productRepository;
  private final StoreMapper storeMapper;

  private static final String OK_MESSAGE = "\"message\":\"OK\"";

  @Override
  @Transactional
  public StoreDto createStore(StoreDto newStore) {
    newStore.setId(null);
    Store store = storeRepository.save(Store.builder()
            .category(newStore.getCategory())
            .name(newStore.getName())
            .owner(
                userRepository.findById(newStore.getOwner())
                .orElseThrow(()-> new NoResultException("user not found"))
            )
        .build());
    newStore.setId(store.getId());
    return newStore;
  }

  @Override
  public StoreDto getStoreByName(String storeName) {
    Store store = storeRepository.getStoreByName(storeName, StoreStatus.ACTIVE.name()).orElseThrow(()-> new NoResultException("store not found"));

    return storeMapper.toDto(store);
  }

  @Override
  @Transactional
  public String updateStore(StoreDto storeDto) {
    Store store = storeRepository.getStoreById(storeDto.getId(),StoreStatus.ACTIVE.name()).orElseThrow(()-> new NoResultException("store not found"));
    store.setCategory(storeDto.getCategory());
    store.setName(storeDto.getName());
    store.setOwner(userRepository.findById(storeDto.getOwner()).orElseThrow(()-> new NoResultException("owner not found")));
    return OK_MESSAGE;
  }

  @Override
  @Transactional
  public String deleteStoreWithNoProducts(Long storeId) {
    Store store = storeRepository.getStoreById(storeId,StoreStatus.ACTIVE.name()).orElseThrow(()-> new NoResultException("store not found"));
    if( store.getProducts().size() > 1){
      throw new NoResultException("can not delete: store has products");
    }
    store.setStatus(StoreStatus.DELETED.name());
    storeRepository.save(store);
    return OK_MESSAGE;
  }

  @Override
  public String loadProducts(Long storeId) {
//    Store store = storeRepository.getStoreById(storeId,StoreStatus.ACTIVE.name()).orElseThrow(()-> new NoResultException("store not found"));

    List<ProductDto> products = productRepository.getProducts();
    return null;
  }
}
