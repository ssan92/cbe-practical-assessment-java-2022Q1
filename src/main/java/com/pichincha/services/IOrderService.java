package com.pichincha.services;

import com.pichincha.domains.dto.RequestOrderDto;
import com.pichincha.domains.jpa.OrderJpa;

public interface IOrderService {

  OrderJpa saveOrder(RequestOrderDto requestOrderDto);
}
