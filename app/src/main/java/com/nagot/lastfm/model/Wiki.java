package com.nagot.lastfm.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nagot on 18/03/2018.
 */

public class Wiki {
    @SerializedName("published")
    private String published;
    @SerializedName("summary")
    private String summary;
    @SerializedName("content")
    private String content;

    public String getPublished() {
        return published;
    }

    public String getSummary() {
        return summary;
    }

    public String getContent() {
        return content;
    }
}
