package com.project.conferencedemo.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class PersistenceConfiguration {
    // this saves the defined configurations to the Spring Context
//    @Bean
//    public DataSource dataSource() throws SQLException {
//        // this checks if a configuration with same name exists, if not it creates, if yes, it'll update
//        DataSourceBuilder builder = DataSourceBuilder.create();
//        builder.url("jdbc:mysql://localhost:3306/conference_demo");
//        System.out.println("Custom datasource has been initialized and set.");
//        return builder.build();
//    }
}
// Why we are doing this? : for working with something complex operations/ working with multiple types of DB

// We can create AutoConfigurations similarly for managing huge applications

//      @Configuration
//      public class MyAutoConfiguration{
//          @Bean
//          public someObject myMethod(){
//          ...
//          }
//      }

// We can read this autoconfigs from spring.factories file in the resources/META-INF/ folder
//  org.springframework.boot.autoconfigure.EnableAutoConfiguration=\com.package.MyAutoConfiguration