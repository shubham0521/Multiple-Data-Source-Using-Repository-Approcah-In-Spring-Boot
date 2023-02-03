//package com.example.read.replica.config;
//
//import java.util.Properties;
//
//import javax.sql.DataSource;
//
//import com.example.read.replica.properties.PostgresProperties;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.stereotype.Component;
//
///**
// * @author shubhamkumar
// */
//
//@Component
//@Slf4j
//public class JdbcPostgresqlConnection {
//
//
//  @Autowired
//  private PostgresProperties postgresProperties;
//
//  @Bean
//  public DataSource dataSource() {
//    Properties parameters = new Properties();
//    parameters.put("user", postgresProperties.getUsername());
//    parameters.put("password", postgresProperties.getPassword());
//    parameters.put("readOnly", true);
//    parameters.put("readOnlyMode", "always");
//
//
//    DriverManagerDataSource dataSource = new DriverManagerDataSource();
//    dataSource.setDriverClassName(postgresProperties.getDriverClassName());
//    dataSource.setUrl(postgresProperties.getUrl());
//    dataSource.setConnectionProperties(parameters);
//    return dataSource;
//  }
//
//}
