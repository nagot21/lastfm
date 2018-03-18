package com.nagot.lastfm.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nagot on 18/03/2018.
 */

public class TrackResponse {
    @SerializedName("results")
    private TrackResults results;

    public TrackResults getResults() {
        return results;
    }
}
