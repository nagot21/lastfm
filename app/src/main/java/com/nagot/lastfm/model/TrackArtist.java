package com.nagot.lastfm.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by IanNagot on 19/03/2018.
 */

public class TrackArtist {
    @SerializedName("name")
    private String name;
    @SerializedName("mbid")
    private String mbid;
    @SerializedName("url")
    private String url;

    public String getName() {
        return name;
    }

    public String getMbid() {
        return mbid;
    }

    public String getUrl() {
        return url;
    }
}
