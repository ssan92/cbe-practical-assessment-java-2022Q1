package com.pichincha.centrodigital.chapter.eva.service.impl;

import com.pichincha.centrodigital.chapter.eva.dto.ShopDto;
import com.pichincha.centrodigital.chapter.eva.dto.ShopRequest;
import com.pichincha.centrodigital.chapter.eva.entity.ShopEntity;
import com.pichincha.centrodigital.chapter.eva.exception.ShopNotFountException;
import com.pichincha.centrodigital.chapter.eva.mapper.ShopMapper;
import com.pichincha.centrodigital.chapter.eva.repository.ShopRepository;
import com.pichincha.centrodigital.chapter.eva.service.ShopService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {

  private final ShopMapper mapper;
  private final ShopRepository repository;

  @Override
  public ShopDto createShop(ShopRequest shopRequest) {
    final var shopEntity = mapper.toEntity(shopRequest);
    final var savedShop = repository.save(shopEntity);

    return mapper.toDto(savedShop);
  }

  @Override
  public ShopDto getShopByName(String name) {
    final var shopEntity = repository.findByName(name)
        .orElseThrow(ShopNotFountException::new);

    return mapper.toDto(shopEntity);
  }

  @Override
  public List<ShopDto> getAll() {
    final var shopEntities = repository.findAll();

    return shopEntities.stream()
        .map(mapper::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public ShopDto updateShop(Integer id, ShopRequest shopRequest) {
    final var shopDb = repository.findById(id).orElseThrow(ShopNotFountException::new);
    final var shop = mapper.toShopEntity(shopDb);

    final var shopEntity = repository.save(shop);

    return mapper.toDto(shopEntity);
  }
}
