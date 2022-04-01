
package com.pichincha.store.repository;


import com.pichincha.store.domain.Product;
import com.pichincha.store.domain.User;
import com.pichincha.store.domain.dto.ProductDto;
import com.pichincha.store.domain.dto.legaci.Response;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository {

  Response getProducts();

}
