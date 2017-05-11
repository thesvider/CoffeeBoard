package com.coffee.domain.config;


import com.coffee.domain.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.facebook.api.Facebook;

public class AuthUtil {
    static final Logger log = LoggerFactory.getLogger(AuthUtil.class);



    public static void authenticate(Connection<?> connection) {

        if(connection.getKey().getProviderId().equals("facebook")){
            Facebook facebook = (Facebook) connection.getApi();
            String [] fields = { "id", "email",  "first_name", "last_name" };
            User userProfile = facebook.fetchObject("me", User.class, fields);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userProfile.getEmail(), null, null);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            log.info("User {} connected.", userProfile);
        }
        else
        if(connection.getKey().getProviderId().equals("twitter")){
            UserProfile userProfile = connection.fetchUserProfile();
            String username = userProfile.getUsername();
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, null, null);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            log.info("User {} {} connected.", userProfile.getFirstName(), userProfile.getLastName());
        }



    }
}

