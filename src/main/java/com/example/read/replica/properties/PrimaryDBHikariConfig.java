package com.example.read.replica.properties;

import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;

/**
 * @author shubhamkumar
 */
public class PrimaryDBHikariConfig extends HikariConfig {
  protected final PrimaryDBHikariWriteProperties hikariWriteProperties;

  protected final String PERSISTENCE_UNIT_NAME = "write";

  protected final Properties JPA_WRITE_PROPERTIES = new Properties() {{
    put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
    put("hibernate.hbm2ddl.auto", "update");
    put("hibernate.ddl-auto", "update");
    put("show-sql", "true");
  }};

  protected PrimaryDBHikariConfig(PrimaryDBHikariWriteProperties hikariWriteProperties) {
    this.hikariWriteProperties = hikariWriteProperties;
    setPoolName(this.hikariWriteProperties.getPoolName());
    setMinimumIdle(this.hikariWriteProperties.getMinimumIdle());
    setMaximumPoolSize(this.hikariWriteProperties.getMaximumPoolSize());
    setIdleTimeout(this.hikariWriteProperties.getIdleTimeout());
  }
}
