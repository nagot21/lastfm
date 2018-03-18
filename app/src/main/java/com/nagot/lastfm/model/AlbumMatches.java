package com.nagot.lastfm.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nagot on 17/03/2018.
 */

public class AlbumMatches {
    @SerializedName("album")
    private List<Album> albumList;

    public List<Album> getAlbumList() {
        return albumList;
    }
}
