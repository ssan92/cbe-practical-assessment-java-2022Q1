package com.pichincha.respositories;

import com.pichincha.domains.jpa.OrderJpa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends CrudRepository<OrderJpa, Integer> {

}
