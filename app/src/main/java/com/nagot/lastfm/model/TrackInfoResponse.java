package com.nagot.lastfm.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by IanNagot on 19/03/2018.
 */

public class TrackInfoResponse {
    @SerializedName("track")
    private TrackInfo trackInfo;

    public TrackInfo getTrackInfo() {
        return trackInfo;
    }
}
