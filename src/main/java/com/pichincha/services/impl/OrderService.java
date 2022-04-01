package com.pichincha.services.impl;

import com.pichincha.domains.dto.RequestOrderDto;
import com.pichincha.domains.jpa.OrderJpa;
import com.pichincha.services.IOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class OrderService implements IOrderService {

  @Override
  public OrderJpa saveOrder(RequestOrderDto requestOrderDto) {
    return null;
  }
}
