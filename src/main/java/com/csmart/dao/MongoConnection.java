package com.csmart.dao;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;

@Component
public class MongoConnection {

    private static MongoClient mongoClient;
    int port = 27017;

    String dbName = "BookIssue";

    private StringBuilder uri = new StringBuilder();

    private MongoClient getMongoClient() throws UnknownHostException {
        if (mongoClient == null) {
            mongoClient = new MongoClient();
        }
        return mongoClient;
    }

    public DB getDatabase() throws UnknownHostException {
        return getMongoClient().getDB(dbName);
    }

    public MongoDbFactory getMongoFactory() throws UnknownHostException {
        return new SimpleMongoDbFactory(getMongoClient(), dbName);
    }
}
