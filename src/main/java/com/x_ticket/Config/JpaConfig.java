package com.x_ticket.Config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class JpaConfig {
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder, DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.x_ticket.Model") // Replace with your entity package
                .properties(getJpaProperties())
                .build();
    }

    private Map<String, Object> getJpaProperties() {
        Map<String, Object> props = new HashMap<>();
        props.put("hibernate.transaction.jta.platform", null);
        props.put("jakarta.persistence.EntityManagerFactory",
                jakarta.persistence.EntityManagerFactory.class.getName());
        return props;
    }
}