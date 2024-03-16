package com.rgb.config;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@AllArgsConstructor
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Value("${spring.data.mongodb.uri}")
    private final String connection;

    @Override
    protected String getDatabaseName() {
        return "db";
    }

    @Bean
    public GridFSBucket gridFsBucket(MongoDatabaseFactory mongoDbFactory) {
        MongoDatabase database = mongoDbFactory.getMongoDatabase();
        return GridFSBuckets.create(database);
    }

    @Bean
    public GridFsTemplate gridFsTemplate(MongoDatabaseFactory mongoDbFactory, MongoTemplate mongoTemplate, GridFSBucket gridFsBucket) {
        return new GridFsTemplate(mongoDbFactory, mongoTemplate.getConverter(), gridFsBucket.getBucketName());
    }

    @Bean
    MongoTransactionManager transactionManager(MongoDatabaseFactory dbFactory) {
        return new MongoTransactionManager(dbFactory);
    }

}
