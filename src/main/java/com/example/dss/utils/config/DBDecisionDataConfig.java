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
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.example.dss.repository.def", // les repositories de la base principale
        entityManagerFactoryRef = "decisionEntityManagerFactory",
        transactionManagerRef = "decisionTransactionManager"
)
public class DBDecisionDataConfig {

    @Bean(name = "decisionDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.decision")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "decisionEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("decisionDataSource") DataSource dataSource,
            JpaProperties jpaProperties) {

        return builder
                .dataSource(dataSource)
                .packages("com.example.dss.model.def") // package des entités
                .persistenceUnit("decisionPU")
                .properties(jpaProperties.getProperties())
                .build();
    }

    @Bean(name = "decisionTransactionManager")
    @Primary
    public PlatformTransactionManager transactionManager(
            @Qualifier("decisionEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
