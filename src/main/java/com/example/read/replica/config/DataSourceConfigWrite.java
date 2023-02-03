package com.example.read.replica.config;

import javax.persistence.EntityManagerFactory;

import com.example.read.replica.properties.PrimaryDBHikariConfig;
import com.example.read.replica.properties.PrimaryDBHikariWriteProperties;
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
@ConfigurationProperties("spring.datasource-write")
@EnableTransactionManagement
@EnableJpaRepositories(
  entityManagerFactoryRef = "entityManagerFactoryWrite",
  transactionManagerRef = "transactionManagerWrite",
  basePackages = {"com.example.read.replica.repository.write"}
)
public class DataSourceConfigWrite extends PrimaryDBHikariConfig {

  public DataSourceConfigWrite(PrimaryDBHikariWriteProperties hikariWriteProperties) {
    super(hikariWriteProperties);
  }

  @Bean
  public HikariDataSource dataSourceWrite() {
    return new HikariDataSource(this);
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactoryWrite(
    final HikariDataSource dataSourceWrite) {

    return new LocalContainerEntityManagerFactoryBean() {{
      setDataSource(dataSourceWrite);
      setPersistenceProviderClass(HibernatePersistenceProvider.class);
      setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
      setPackagesToScan(MODEL_PACKAGE);
      setJpaProperties(JPA_WRITE_PROPERTIES);
    }};
  }

  @Bean
  public PlatformTransactionManager transactionManagerWrite(EntityManagerFactory entityManagerFactoryWrite) {
    return new JpaTransactionManager(entityManagerFactoryWrite);
  }
}
