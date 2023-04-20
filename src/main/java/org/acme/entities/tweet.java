package org.acme.entities;

import java.util.Date;

public class tweet {
    private int userid;
    private Date timestamp;
    private String description;

    public tweet(int userid, Date updateTime, String description) {
        this.userid = userid;
        this.timestamp = updateTime;
        this.description = description;
    }

    public int getUserid() {
        return userid;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getDescription() {
        return description;
    }
}
