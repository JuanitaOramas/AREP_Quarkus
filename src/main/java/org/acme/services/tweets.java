package org.acme.services;

import com.mongodb.client.MongoClient;
import javax.inject.Inject;

import com.mongodb.client.MongoCollection;
import org.acme.entities.tweet;
import org.bson.Document;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Path("/tweets")

public class tweets {
    @Inject
    MongoClient mongoClient;

    // GET
    @GET
    public  List<String> getAllTweets() {
        MongoCollection<Document> collection = getCollection();

        List<String> tweets = new ArrayList<>();
        for (Document document : collection.find()) {
            tweets.add(document.toJson());
        }
        return tweets;
    }

    //POST
    @POST
    public Response  postTweet(tweet t) {
        MongoCollection<Document> collection = getCollection();
        Document document = new Document()
                .append("username", t.getUsername())
                .append("description", t.getDescription())
                .append("timestamp", new Date());

        collection.insertOne(document);
        return Response.status(Response.Status.CREATED).build();

    }


    public MongoCollection<Document> getCollection() {
        return mongoClient.getDatabase("test").getCollection("tweets");
    }


}
