package com.coffee.domain.controller;


import com.coffee.domain.config.AuthUtil;
import com.coffee.domain.config.DatabaseSocialConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Role;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.connect.*;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.*;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth1.AuthorizedRequestToken;
import org.springframework.social.oauth1.OAuth1Operations;
import org.springframework.social.oauth1.OAuth1Parameters;
import org.springframework.social.oauth1.OAuthToken;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

@Controller
public class SignupController {
//    private final ProviderSignInUtils signInUtils;

    @GetMapping("/twitter/login")
    public void login(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
        TwitterConnectionFactory connectionFactory = new
                TwitterConnectionFactory("VAXcFyKXPuKN7wjCgDyWAjwdD", "rvLdYqM8yDWdRHS8D2jMkkYDQfwcA0SRBe8eEnUnjEDGdagxFG");
        OAuth1Operations oauthOperations =
                connectionFactory.getOAuthOperations();
        OAuthToken requestToken =
                oauthOperations.fetchRequestToken("http://127.0.0.1:8090/tw/callback", null);

        request.getSession().setAttribute("requestToken",
                requestToken);
        String authorizeUrl =oauthOperations.buildAuthenticateUrl(requestToken.getValue(), OAuth1Parameters.NONE);
        response.addCookie(new Cookie("requestSecret", requestToken.getSecret()));
        response.addCookie(new Cookie("requestValue", requestToken.getValue()));
        response.sendRedirect(authorizeUrl);

    }
    @Autowired
    DataSource dataSource;

    @Autowired
    Environment env;

    @Autowired
    DatabaseSocialConfigurer databaseSocialConfigurer;

    @RequestMapping("/tw/callback")
    public String callback(String oauth_token, String
            oauth_verifier, HttpServletRequest request) {
        TwitterConnectionFactory connectionFactory = new
                TwitterConnectionFactory("VAXcFyKXPuKN7wjCgDyWAjwdD",
                "rvLdYqM8yDWdRHS8D2jMkkYDQfwcA0SRBe8eEnUnjEDGdagxFG");
        OAuthToken requestToken = (OAuthToken)  request.getSession().getAttribute("requestToken");
        OAuth1Operations oAuthOperations = connectionFactory.getOAuthOperations();
        OAuthToken token = oAuthOperations.exchangeForAccessToken(new AuthorizedRequestToken(requestToken, oauth_verifier), null);
        request.getSession().setAttribute("twitterToken", token);

        Connection<Twitter> connection = connectionFactory.createConnection(token);
        Twitter twitter = connection != null ?
                connection.getApi() :
                new TwitterTemplate(
                        env.getProperty("VAXcFyKXPuKN7wjCgDyWAjwdD"),
                        env.getProperty("rvLdYqM8yDWdRHS8D2jMkkYDQfwcA0SRBe8eEnUnjEDGdagxFG"));

        TwitterProfile profile = twitter.userOperations().getUserProfile();
        UserProfile userProfile = connection.fetchUserProfile();
        String username = userProfile.getUsername();
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, null, null);
        SecurityContextHolder.getContext().setAuthentication(authentication);



        return "redirect:/";
    }



}

