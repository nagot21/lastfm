package com.nagot.lastfm.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by IanNagot on 16/03/2018.
 */

public class Image {
    @SerializedName("#text")
    private String url;
    @SerializedName("size")
    private String size;

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
