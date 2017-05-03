package com.coffee.domain.service;

import com.coffee.domain.model.Coffee;
import org.springframework.stereotype.Service;

/**
 * Created by olga on 03.05.2017.
 */
@Service
public interface ReviewService {
       double averageRateByCoffeId(Long id);

       double averageRateByCoffeId(Coffee coffee);
}
