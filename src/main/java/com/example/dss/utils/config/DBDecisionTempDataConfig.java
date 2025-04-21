package com.example.dss.utils.config;

import jakarta.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.*;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.dss.repository.temp", // ou un package différent
        entityManagerFactoryRef = "tempDecisionEntityManagerFactory",
        transactionManagerRef = "tempDecisionTransactionManager"
)
public class DBDecisionTempDataConfig {

    @Bean(name = "tempDecisionDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.decisiontemp")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "tempDecisionEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("tempDecisionDataSource") DataSource dataSource
    ) {
        return builder
                .dataSource(dataSource)
                .packages("com.example.dss.model.temp") // ou com.example.dss.model.temp si tu les sépares
                .persistenceUnit("tempDecisionPU")
                .build();
    }

    @Bean(name = "tempDecisionTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("tempDecisionEntityManagerFactory") EntityManagerFactory entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
