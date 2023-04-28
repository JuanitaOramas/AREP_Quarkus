package org.acme.services;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.acme.entities.user;
import javax.ws.rs.core.Response;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/users")
public class users {
    @Inject
    MongoClient mongoClient;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDocuments(user u) {
        MongoCollection<Document> collection = getCollection();
        Document query = new Document("username", u.getUsername())
            .append("password", u.getPassword());
        Document result = collection.find(query).first();
        if (result != null) {
            return Response.status(202).build();
        } else {
            return Response.status(401).build();
        }
    }

    public MongoCollection<Document> getCollection() {
        return mongoClient.getDatabase("test").getCollection("users");
    }
}
