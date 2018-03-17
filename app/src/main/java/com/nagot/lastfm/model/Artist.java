package com.nagot.lastfm.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by IanNagot on 16/03/2018.
 */

public class Artist {
    @SerializedName("name")
    private String name;
    @SerializedName("listeners")
    private int listeners;
    @SerializedName("mbid")
    private String mbid;
    @SerializedName("url")
    private String url;
    @SerializedName("streamable")
    private int streamable;
    @SerializedName("image")
    private List<Image> imageList;

    public String getName() {
        return name;
    }

    public int getListeners() {
        return listeners;
    }

    public String getMbid() {
        return mbid;
    }

    public String getUrl() {
        return url;
    }

    public int getStreamable() {
        return streamable;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public String getImageUrl(){
        if (getImageList() != null && getImageList().size() > 0) {
            for (Image img :
                    getImageList()) {
                if (img.getSize().equalsIgnoreCase("large")) {
                    return img.getUrl();
                }
            }
        }
        return null;
    }
}
