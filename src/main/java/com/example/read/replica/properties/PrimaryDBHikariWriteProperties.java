package com.example.read.replica.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author shubhamkumar
 */

@Setter
@Getter
@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties("spring.datasource-write.hikari")
public class PrimaryDBHikariWriteProperties {
  private String poolName;

  private int minimumIdle;

  private int maximumPoolSize;

  private int idleTimeout;
}
