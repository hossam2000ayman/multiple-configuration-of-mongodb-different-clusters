package com.example.multi_mongodb_project.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(
        basePackages = {"com.example.multi_mongodb_project.model1"},
        mongoTemplateRef = "newdb1MongoTemplate"
)
public class NewDb1Config {

}
