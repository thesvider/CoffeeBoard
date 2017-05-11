package com.coffee.domain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import static org.springframework.http.HttpHeaders.USER_AGENT;

@Controller
public class MainController {

    @RequestMapping("/hello")
    public String login()
    {
        return "index";
    }

}
