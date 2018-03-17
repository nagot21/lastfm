package com.nagot.lastfm.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nagot on 17/03/2018.
 */

public class ArtistResponse {
    @SerializedName("artistmatches")
    private ArtistMatches artistMatches;

    public ArtistMatches getArtistMatches() {
        return artistMatches;
    }
}
