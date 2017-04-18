package com.coffee.domain.repository;

import com.coffee.domain.model.Coffee;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by nsvid on 07.03.2017.
 */
public interface CoffeeRepository extends CrudRepository<Coffee, Long> {
}
