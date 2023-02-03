package com.example.read.replica.config;

import javax.persistence.EntityManagerFactory;

import com.example.read.replica.properties.SecondaryDBHikariConfig;
import com.example.read.replica.properties.SecondaryDBHikariWriteProperties;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import static com.example.read.replica.Application.MODEL_PACKAGE;

/**
 * @author shubhamkumar
 */

@Configuration
@ConfigurationProperties("spring.datasource-read")
@EnableTransactionManagement
@EnableJpaRepositories(
  entityManagerFactoryRef = "entityManagerFactoryRead",
  transactionManagerRef = "transactionManagerRead",
  basePackages = {"com.example.read.replica.repository.read"}
)
public class DataSourceConfigRead extends SecondaryDBHikariConfig {
  public DataSourceConfigRead(SecondaryDBHikariWriteProperties hikariReadProperties) {
    super(hikariReadProperties);
  }

  @Bean
  public HikariDataSource dataSourceRead() {
    return new HikariDataSource(this);
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactoryRead(
    final HikariDataSource dataSourceRead) {

    return new LocalContainerEntityManagerFactoryBean() {{
      setDataSource(dataSourceRead);
      setPersistenceProviderClass(HibernatePersistenceProvider.class);
      setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
      setPackagesToScan(MODEL_PACKAGE);
      setJpaProperties(JPA_READ_PROPERTIES);
    }};
  }

  @Bean
  public PlatformTransactionManager transactionManagerRead(EntityManagerFactory entityManagerFactoryRead) {
    return new JpaTransactionManager(entityManagerFactoryRead);
  }
}
