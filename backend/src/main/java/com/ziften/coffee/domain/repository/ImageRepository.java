package com.coffee.server.domain.repository;

import com.coffee.server.domain.model.Image;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by nsvid on 22.03.2017.
 */
public interface ImageRepository extends CrudRepository<Image, Long>{
}
