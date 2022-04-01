package com.pichincha.respositories;

import com.pichincha.domains.jpa.OrderDetailJpa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderDetailRepository extends CrudRepository<OrderDetailJpa, Integer> {

}
