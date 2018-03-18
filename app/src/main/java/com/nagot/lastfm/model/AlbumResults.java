package com.nagot.lastfm.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nagot on 17/03/2018.
 */

public class AlbumResults {
    @SerializedName("albummatches")
    private AlbumMatches albumMatches;

    public AlbumMatches getAlbumMatches() {
        return albumMatches;
    }
}
