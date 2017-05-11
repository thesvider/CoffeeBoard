package com.coffee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan
@EnableAutoConfiguration
public class BoardApplication {

	/*@Bean
	public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter(){
		return new ApplicationSecurity();
	}
*/
	public static void main(String[] args) {
		SpringApplication.run(BoardApplication.class, args);
	}
}
