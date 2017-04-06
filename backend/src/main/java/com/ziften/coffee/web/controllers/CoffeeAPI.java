package com.coffee.server.web.controllers;

import com.coffee.server.domain.model.Coffee;
import com.coffee.server.domain.model.Image;
import com.coffee.server.domain.model.Review;
import com.coffee.server.domain.repository.CoffeeRepository;
import com.coffee.server.domain.repository.ImageRepository;
import com.coffee.server.domain.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 * Created by nsvid on 07.03.2017.
 */
@RestController
@RequestMapping("/api/coffee")
public class CoffeeAPI {

    @Autowired
    CoffeeRepository coffeeRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    ImageRepository imageRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Coffee> findAll() {
        return coffeeRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Coffee findOne(@PathVariable("id") Long id) {
        return coffeeRepository.findOne(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Coffee saveCoffee(@RequestBody Coffee coffee) {
        Date timeNow = new Date(Calendar.getInstance().getTimeInMillis());
        coffee.setIntroduced(timeNow);
        return coffeeRepository.save(coffee);
    }

    @RequestMapping(value = "/review", method = RequestMethod.POST)
    public Review saveReview(@RequestBody Review review) {
        Timestamp timestamp = new Timestamp(Calendar.getInstance().getTimeInMillis());
        review.setTimestamp(timestamp);
        return reviewRepository.save(review);
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
}
