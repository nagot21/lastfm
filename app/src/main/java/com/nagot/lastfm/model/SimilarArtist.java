package com.nagot.lastfm.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nagot on 18/03/2018.
 */

public class SimilarArtist {
    @SerializedName("name")
    private String name;
    @SerializedName("url")
    private String url;
    @SerializedName("image")
    private List<Image> imageList;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
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
