package com.nagot.lastfm.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nagot on 18/03/2018.
 */

public class ArtistInfo {
    @SerializedName("name")
    private String name;
    @SerializedName("image")
    private List<Image> imageList;
    @SerializedName("similar")
    private Similar similar;
    @SerializedName("tags")
    private List<Tag> tagList;
    @SerializedName("bio")
    private ArtistBiography artistBiography;

    public String getName() {
        return name;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public Similar getSimilar() {
        return similar;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public ArtistBiography getArtistBiography() {
        return artistBiography;
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
