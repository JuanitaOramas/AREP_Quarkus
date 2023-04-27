package org.acme.entities;

import javax.persistence.Entity;
import java.util.Date;

public class tweet  {
    private String username;
    private Date timestamp;
    private String description;

    public tweet(String username, String description, Date timestamp) {
        this.username = username;
        this.timestamp = timestamp;
        this.description = description;
    }


    public String getUsername() {
        return username;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getDescription() {
        return description;
    }
}
