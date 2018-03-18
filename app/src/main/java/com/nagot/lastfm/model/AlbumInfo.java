package com.nagot.lastfm.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nagot on 18/03/2018.
 */

public class AlbumInfo {
    @SerializedName("name")
    private String name;
    @SerializedName("artist")
    private String artist;
    @SerializedName("mbid")
    private String mbid;
    @SerializedName("url")
    private String url;
    @SerializedName("image")
    private List<Image> imageList;
    @SerializedName("listeners")
    private int listeners;
    @SerializedName("playcount")
    private int playcount;
    @SerializedName("tracks")
    private Tracks tracks;
    @SerializedName("tags")
    private Tags tags;
    @SerializedName("wiki")
    private Wiki wiki;

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getMbid() {
        return mbid;
    }

    public String getUrl() {
        return url;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public int getListeners() {
        return listeners;
    }

    public int getPlaycount() {
        return playcount;
    }

    public Tracks getTracks() {
        return tracks;
    }

    public Tags getTags() {
        return tags;
    }

    public Wiki getWiki() {
        return wiki;
    }

    public String getImageUrl(){
        if (getImageList() != null && getImageList().size() > 0) {
            for (Image img : getImageList()) {
                if (img.getSize().equals("extralarge") || img.getSize().equals("mega") ||
                        img.getSize().equals("")) {
                    return img.getUrl();
                }
            }
        }
        return null;
    }
}
