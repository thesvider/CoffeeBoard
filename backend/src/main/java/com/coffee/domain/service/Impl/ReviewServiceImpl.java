package com.coffee.domain.service.Impl;

import com.coffee.domain.model.Coffee;
import com.coffee.domain.model.Review;
import com.coffee.domain.repository.CoffeeRepository;
import com.coffee.domain.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Set;

/**
 * Created by olga on 03.05.2017.
 */
@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private CoffeeRepository coffeeRepository;

    @Override
    public double averageRateByCoffeId(Long id) {
        Coffee coffee = coffeeRepository.findOne(id);
        Set<Review> reviews = coffee.getReviews();
        int a = reviews.stream().mapToInt(Review::getRate).sum();
        return (double) a / reviews.size();
    }

    @Override
    public double averageRateByCoffeId(Coffee coffee) {
        Set<Review> reviews = coffee.getReviews();
        int a = reviews.stream().mapToInt(Review::getRate).sum();
        return (double) a / reviews.size();
    }
}
