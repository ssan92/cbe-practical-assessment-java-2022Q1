
package com.pichincha.store.repository;


import com.pichincha.store.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
