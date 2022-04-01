package com.pichincha.respositories;

import com.pichincha.domains.jpa.ProductJpa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends CrudRepository<ProductJpa, Integer> {
}
