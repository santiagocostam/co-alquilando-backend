package com.projectfinal.coalquilando.services;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class DataBaseManager {

    // TODO: Set this config in a resource to consume database. Setup with local credentials until cloud version it's deployed
    final String uriString = "mongodb://camila-stock:$[password]@localhost:27017/CoAlquilando?authSource=camila-stock";
    private MongoClient mongoClient;

    protected void getMongoDataBase() {
        mongoClient= MongoClients.create(uriString);

    }

}
