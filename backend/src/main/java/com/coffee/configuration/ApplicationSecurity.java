package com.coffee.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

  @Autowired
  private RESTAuthenticationEntryPoint authenticationEntryPoint;
  @Autowired
  private RESTAuthenticationSuccessHandler successHandler;
  @Autowired
  private RESTAuthenticationFailureHandler failureHandler;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication().withUser("coffeeMan").password("coffee").roles("USER");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
    .authorizeRequests()
    .antMatchers("/api/**").authenticated();
    http
    .csrf()
    .disable();
    http
    .exceptionHandling()
    .authenticationEntryPoint(authenticationEntryPoint);
    http
    .formLogin()
    .successHandler(successHandler);
    http
    .formLogin()
    .failureHandler(failureHandler);
    super.configure(http);
  }
}
