package com.nagot.lastfm.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nagot on 17/03/2018.
 */

public class ArtistResponse {
    @SerializedName("results")
    private ArtistResults results;

    public ArtistResults getResults() {
        return results;
    }
}
