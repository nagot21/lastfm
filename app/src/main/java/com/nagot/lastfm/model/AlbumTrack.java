package com.nagot.lastfm.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nagot on 18/03/2018.
 */

public class AlbumTrack {
    @SerializedName("name")
    private String name;
    @SerializedName("url")
    private String url;
    @SerializedName("duration")
    private String duration;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getDuration() {
        return duration;
    }
}
