package com.nagot.lastfm.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nagot on 18/03/2018.
 */

public class Similar {
    @SerializedName("artist")
    private List<SimilarArtist> similarArtistList;

    public List<SimilarArtist> getSimilarArtistList() {
        return similarArtistList;
    }
}
