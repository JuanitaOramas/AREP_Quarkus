package org.acme;

import com.mongodb.client.MongoClient;
import javax.inject.Inject;

import com.mongodb.client.MongoCollection;
import org.acme.entities.tweet;
import org.bson.Document;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Path("/tweets")
public class tweets {
    @Inject
    MongoClient mongoClient;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public  List<String> getAllTweets() {
        MongoCollection<Document> collection = getCollection();

        List<String> tweets = new ArrayList<>();
        for (Document document : collection.find()) {
            tweets.add(document.toJson());
        }
        return tweets;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postTweet(tweet tweet) {
        MongoCollection<Document> collection = getCollection();



        Document document = new Document()
                .append("userName", tweet.getUserid())
                .append("description", tweet.getDescription())
                .append("timestamp", new Date());

        collection.insertOne(document);
    }

    public MongoCollection<Document> getCollection() {
        return mongoClient.getDatabase("test").getCollection("tweets");
    }


}
