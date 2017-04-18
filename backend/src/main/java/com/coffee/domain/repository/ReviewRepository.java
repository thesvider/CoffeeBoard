package com.coffee.domain.repository;

import com.coffee.domain.model.Review;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by nsvid on 08.03.2017.
 */
public interface ReviewRepository extends CrudRepository<Review, Long>{
}
