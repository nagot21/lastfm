package com.nagot.lastfm.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nagot on 18/03/2018.
 */

public class ArtistInfoResponse {
    @SerializedName("artist")
    private ArtistInfo artistInfo;

    public ArtistInfo getArtistInfo() {
        return artistInfo;
    }
}
