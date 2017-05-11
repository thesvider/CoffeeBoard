package com.coffee.web.controllers;

import com.coffee.domain.model.Coffee;
import com.coffee.domain.model.Image;
import com.coffee.domain.model.Review;
import com.coffee.domain.repository.CoffeeRepository;
import com.coffee.domain.repository.ImageRepository;
import com.coffee.domain.repository.ReviewRepository;
import com.coffee.domain.service.AuthenticationService;
import com.coffee.domain.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 * Created by nsvid on 07.03.2017.
 */
@RestController
@RequestMapping("/api/coffee")
public class CoffeeAPI {

    @Autowired
    private CoffeeRepository coffeeRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Coffee> findAll() {

      //  String s = authenticationService.getUserEmail();
        List<Coffee> coffeeList = coffeeRepository.findAll();
        sortCoffeeByRate(coffeeList);
        return coffeeList;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Coffee findOne(@PathVariable("id") Long id) {
        return coffeeRepository.findOne(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Coffee saveCoffee(@RequestBody Coffee coffee) {
        Date timeNow = new Date(Calendar.getInstance().getTimeInMillis());
        coffee.setIntroduced(timeNow);
        coffee.setRate(0.0);
        return coffeeRepository.save(coffee);
    }

    @RequestMapping(value = "/review", method = RequestMethod.POST)
    public Review saveReview(@RequestBody Review review) {
        Timestamp timestamp = new Timestamp(Calendar.getInstance().getTimeInMillis());
        review.setTimestamp(timestamp);
        Review review1 = reviewRepository.save(review);
        Coffee coffee = coffeeRepository.findOne(review1.getCoffee().getId());
        coffee.setRate(reviewService.averageRateByCoffeId(coffee));
        coffeeRepository.save(coffee);
        return review1;
    }

    @RequestMapping(value = "/image/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file, @PathVariable("id") Long id) {
        Image image = new Image();
        try {
            Coffee coffee = coffeeRepository.findOne(id);
            image.setContent(file.getBytes());
            image.setFileName(file.getOriginalFilename());
            image.setCoffee(coffee);
            imageRepository.save(image);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity("done", HttpStatus.OK);
    }

    private void sortCoffeeByRate(List<Coffee> coffees) {
        Collections.sort(coffees, (coffees1, coffees2) -> Double.compare(coffees2.getRate(), coffees1.getRate()));
    }
}
