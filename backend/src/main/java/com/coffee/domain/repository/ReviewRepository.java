package com.coffee.domain.repository;

import com.coffee.domain.model.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by nsvid on 08.03.2017.
 */
public interface ReviewRepository extends CrudRepository<Review, Long>{

    @Query("SELECT AVG(rate) from Review where coffee_id=:coffee_id")
    public double findAverageByCoffeeId (@Param("coffee_id") long coffee_id);
}
