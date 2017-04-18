package com.coffee.web.controllers;

import com.coffee.domain.model.Image;
import com.coffee.domain.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by nsvid on 25.03.2017.
 */
@Controller
@RequestMapping("/api/image/")
public class ImageAPI {

    @Autowired
    ImageRepository imageRepository;

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public void getImage(@PathVariable("id") Long id, HttpServletResponse response) {
        Image image = imageRepository.findOne(id);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        try {
            response.getOutputStream().write(image.getContent());
            response.getOutputStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
