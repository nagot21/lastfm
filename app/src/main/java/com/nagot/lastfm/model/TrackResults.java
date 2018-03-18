package com.nagot.lastfm.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nagot on 18/03/2018.
 */

public class TrackResults {
    @SerializedName("trackmatches")
    private TrackMatches trackMatches;

    public TrackMatches getTrackMatches() {
        return trackMatches;
    }
}
