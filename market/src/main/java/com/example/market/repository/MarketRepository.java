package com.example.market.repository;

import com.example.market.model.MarketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarketRepository extends JpaRepository<MarketEntity, Integer> {

  List<MarketEntity> findByName(String name);
}
