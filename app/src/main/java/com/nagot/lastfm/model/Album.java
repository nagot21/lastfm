package com.nagot.lastfm.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nagot on 17/03/2018.
 */

public class Album {
    @SerializedName("name")
    private String name;
    @SerializedName("artist")
    private String artist;
    @SerializedName("url")
    private String url;
    @SerializedName("image")
    private List<Image> imageList;
    @SerializedName("streamable")
    private int streamable;
    @SerializedName("mbid")
    private String mbid;

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getUrl() {
        return url;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public int getStreamable() {
        return streamable;
    }

    public String getMbid() {
        return mbid;
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
