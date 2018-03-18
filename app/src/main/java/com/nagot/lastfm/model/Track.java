package com.nagot.lastfm.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nagot on 18/03/2018.
 */

public class Track {
    @SerializedName("name")
    private String name;
    @SerializedName("artist")
    private String artist;
    @SerializedName("url")
    private String url;
    @SerializedName("streamable")
    private String streamable;
    @SerializedName("listeners")
    private int listeners;
    @SerializedName("image")
    private List<Image> imageList;
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

    public String getStreamable() {
        return streamable;
    }

    public int getListeners() {
        return listeners;
    }

    public List<Image> getImageList() {
        return imageList;
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
