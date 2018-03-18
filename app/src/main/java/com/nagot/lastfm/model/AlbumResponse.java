package com.nagot.lastfm.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nagot on 17/03/2018.
 */

public class AlbumResponse {
    @SerializedName("results")
    private AlbumResults results;

    public AlbumResults getResults() {
        return results;
    }
}
