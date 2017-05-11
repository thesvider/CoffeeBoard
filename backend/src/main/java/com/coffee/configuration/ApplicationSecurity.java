package com.coffee.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

/*  @Autowired
  private RESTAuthenticationEntryPoint authenticationEntryPoint;
  @Autowired
  private RESTAuthenticationSuccessHandler successHandler;
  @Autowired
  private RESTAuthenticationFailureHandler failureHandler;*/

  @Autowired
  private UserDetailsService userDetailsService;


  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//        auth
//                .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
    .authorizeRequests()
    .antMatchers("/api/coffee/**", "/api/login","/api/signup").permitAll()
            .antMatchers("/api/userdetais").authenticated()
       .anyRequest().authenticated()
      /*       .and()
           .formLogin()
            .loginPage("/login")
            .permitAll()*/
            .and()
         /*   .exceptionHandling().accessDeniedPage(accessDeniedHandler())
            .and()
         */   .logout().logoutUrl("/logout").logoutSuccessUrl("/login")
            .and()
            .exceptionHandling().accessDeniedHandler(accessDeniedHandler())
            .and()
            .csrf().disable();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public AccessDeniedHandler accessDeniedHandler(){
    return new CustomAccessDeniedHandler();
  }

}
