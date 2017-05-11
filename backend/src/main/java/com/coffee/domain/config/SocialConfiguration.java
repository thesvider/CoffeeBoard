package com.coffee.domain.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.web.ProviderSignInController;
import org.springframework.social.connect.web.SignInAdapter;

@Configuration
public class SocialConfiguration {

    //hadle sign-in process
    @Bean
    public SignInAdapter authSignInAdapter() {
        return (userId, connection, request) -> {
            AuthUtil.authenticate(connection);
            return null;
        };
    }



    @Bean
    public DatabaseSocialConfigurer databaseSocialConfigurer(){
        return new DatabaseSocialConfigurer();
    }
}

