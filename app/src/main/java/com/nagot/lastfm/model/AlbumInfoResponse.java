package com.nagot.lastfm.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nagot on 18/03/2018.
 */

public class AlbumInfoResponse {
    @SerializedName("album")
    private AlbumInfo albumInfo;

    public AlbumInfo getAlbumInfo() {
        return albumInfo;
    }
}
