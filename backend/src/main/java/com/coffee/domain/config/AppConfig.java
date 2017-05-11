package com.coffee.domain.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class AppConfig {
    @Autowired
    private Environment environment;

    private Properties connectionProperties() {
        Properties properties = new Properties();
        properties.setProperty("useUnicode", environment.getRequiredProperty("useUnicode"));
        properties.setProperty("characterEncoding", environment.getRequiredProperty("characterEncoding"));
        return properties;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(environment.getRequiredProperty("spring.datasource.url"));
        dataSource.setUsername(environment.getRequiredProperty("spring.datasource.username"));
        dataSource.setPassword(environment.getRequiredProperty("spring.datasource.password"));
        dataSource.setConnectionProperties(connectionProperties());
        return dataSource;
    }

}
