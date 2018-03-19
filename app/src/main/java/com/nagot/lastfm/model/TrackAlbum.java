package com.nagot.lastfm.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by IanNagot on 19/03/2018.
 */

public class TrackAlbum {
    @SerializedName("artist")
    private String artist;
    @SerializedName("title")
    private String title;
    @SerializedName("mbid")
    private String mbid;
    @SerializedName("url")
    private String url;
    @SerializedName("image")
    private List<Image> imageList;

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
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
