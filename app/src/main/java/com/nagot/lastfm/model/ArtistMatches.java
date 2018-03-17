package com.nagot.lastfm.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nagot on 17/03/2018.
 */

class ArtistMatches {
    @SerializedName("artist")
    private List<Artist> artistList;

    public List<Artist> getArtistList() {
        return artistList;
    }
}
