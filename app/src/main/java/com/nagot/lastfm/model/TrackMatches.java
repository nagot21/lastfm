package com.nagot.lastfm.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nagot on 18/03/2018.
 */

public class TrackMatches {
    @SerializedName("track")
    private List<Track> trackList;

    public List<Track> getTrackList() {
        return trackList;
    }
}
