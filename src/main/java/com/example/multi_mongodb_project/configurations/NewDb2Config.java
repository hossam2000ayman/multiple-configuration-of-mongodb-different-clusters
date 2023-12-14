package com.example.multi_mongodb_project.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(
        basePackages = {"com.example.multi_mongodb_project.model2"},
        mongoTemplateRef = "newdb2MongoTemplate"
)
public class NewDb2Config {
}
