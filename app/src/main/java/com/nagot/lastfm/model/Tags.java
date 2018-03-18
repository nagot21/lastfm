package com.nagot.lastfm.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nagot on 18/03/2018.
 */

public class Tags {
    @SerializedName("tag")
    private List<Tag> tagList;

    public List<Tag> getTagList() {
        return tagList;
    }
}
