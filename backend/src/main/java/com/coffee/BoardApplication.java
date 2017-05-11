package com.coffee;

import com.coffee.configuration.ApplicationSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class BoardApplication {

	@Bean
	public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter(){
		return new ApplicationSecurity();
	}

	public static void main(String[] args) {
		SpringApplication.run(BoardApplication.class, args);
	}
}
