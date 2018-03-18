package com.nagot.lastfm.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nagot on 18/03/2018.
 */

public class Tracks {
    @SerializedName("track")
    private List<AlbumTrack> albumTrackList;

    public List<AlbumTrack> getAlbumTrackList() {
        return albumTrackList;
    }
}
