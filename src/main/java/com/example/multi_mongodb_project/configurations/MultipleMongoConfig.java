package com.example.multi_mongodb_project.configurations;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MultipleMongoConfig {


    //todo Mongo Properties
    @Primary
    @Bean(name = "newdb1Properties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.newdb1")
    public MongoProperties getNewDb1Properties(){
        return new MongoProperties();
    }

    @Bean(name = "newdb2Properties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.newdb2")
    public MongoProperties getNewDb2Properties(){
        return new MongoProperties();
    }

    //todo MongoDatabaseFactory
    @Primary
    @Bean
    public MongoDatabaseFactory newdb1MongoDatabaseFactory(MongoProperties properties){
        return new SimpleMongoClientDatabaseFactory(properties.getUri());
    }

    @Bean
    public MongoDatabaseFactory newdb2MongoDatabaseFactory(MongoProperties properties){
        return new SimpleMongoClientDatabaseFactory(properties.getUri());
    }


    //todo MongoTemplate
    @Primary
    @Bean(name = "newdb1MongoTemplate")
    public MongoTemplate newDb1MongoTemplate(){
        return new MongoTemplate(newdb1MongoDatabaseFactory(getNewDb1Properties()));
    }

    @Bean(name = "newdb2MongoTemplate")
    public MongoTemplate newDb2MongoTemplate(){
        return new MongoTemplate(newdb2MongoDatabaseFactory(getNewDb2Properties()));
    }


}
