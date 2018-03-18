package com.nagot.lastfm.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nagot on 18/03/2018.
 */

public class Tag {
    @SerializedName("name")
    private String name;
    @SerializedName("url")
    private String url;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
