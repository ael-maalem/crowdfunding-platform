package com.crowdfunding.investmentservice.configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@Configuration
@EnableMongoRepositories ("com.crowdfunding.investmentservice.Repository")
public class MongoConfiguration extends AbstractMongoClientConfiguration {

    private String MONGO_URI;
    private static String MONGODB_USER = System.getenv("MONGODB_USER");
    private static String MONGODB_PASS = System.getenv("MONGODB_PASS");
    private static String MONGODB_HOST = System.getenv("MONGODB_HOST");
    private static String MONGODB_PORT = "27017";
    private static String MONGODB_NAME = System.getenv("MONGODB_NAME");
    private static final Logger logger = LogManager.getLogger(MongoConfiguration.class);


    @Override
    protected void configureClientSettings(MongoClientSettings.Builder builder) {
        logger.info("Start Connecting to the database");
        MONGO_URI = "mongodb://"+MONGODB_USER+":"+MONGODB_PASS+"@"+MONGODB_HOST+":"+MONGODB_PORT+"/"+MONGODB_NAME+"?authSource=admin";
        builder.applyConnectionString(new ConnectionString(MONGO_URI));
        logger.info("Success Connected to the Database");
    }

    @Override
    protected String getDatabaseName() {
        return MONGODB_NAME;
    }
}



