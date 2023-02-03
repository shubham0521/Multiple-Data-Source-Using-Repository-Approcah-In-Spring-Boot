package com.example.read.replica.properties;

import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;

/**
 * @author shubhamkumar
 */
public class SecondaryDBHikariConfig extends HikariConfig {
  protected final SecondaryDBHikariWriteProperties hikariReadProperties;

  protected final String PERSISTENCE_UNIT_NAME = "read";

  protected final Properties JPA_READ_PROPERTIES = new Properties() {{
    put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
    put("hibernate.hbm2ddl.auto", "update");
    put("hibernate.ddl-auto", "update");
    put("show-sql", "true");
  }};

  protected SecondaryDBHikariConfig(SecondaryDBHikariWriteProperties hikariReadProperties) {
    this.hikariReadProperties = hikariReadProperties;
    setPoolName(this.hikariReadProperties.getPoolName());
    setMinimumIdle(this.hikariReadProperties.getMinimumIdle());
    setMaximumPoolSize(this.hikariReadProperties.getMaximumPoolSize());
    setIdleTimeout(this.hikariReadProperties.getIdleTimeout());
  }
}
