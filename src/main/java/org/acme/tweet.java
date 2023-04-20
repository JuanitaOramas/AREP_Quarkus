package org.acme;

import com.mongodb.client.MongoClient;
import javax.inject.Inject;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/tweets")
public class tweet {
    @Inject
    MongoClient mongoClient;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getAllDocuments() {
        MongoCollection<Document> collection = getCollection();
        List<String> documentStrings = new ArrayList<>();
        for (Document document : collection.find()) {
            documentStrings.add(document.toJson());
        }
        return documentStrings;
    }

    public MongoCollection<Document> getCollection() {
        return mongoClient.getDatabase("test").getCollection("users");
    }
}
