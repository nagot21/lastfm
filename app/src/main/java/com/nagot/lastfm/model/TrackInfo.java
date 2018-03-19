package com.nagot.lastfm.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by IanNagot on 19/03/2018.
 */

public class TrackInfo {
    @SerializedName("name")
    private String name;
    @SerializedName("mbid")
    private String mbid;
    @SerializedName("url")
    private String url;
    @SerializedName("duration")
    private int duration;
    @SerializedName("listeners")
    private int listeners;
    @SerializedName("playcount")
    private int playcount;
    @SerializedName("artist")
    private TrackArtist trackArtist;
    @SerializedName("album")
    private TrackAlbum trackAlbum;
    @SerializedName("wiki")
    private Wiki wiki;

    public String getName() {
        return name;
    }

    public String getMbid() {
        return mbid;
    }

    public String getUrl() {
        return url;
    }

    public int getDuration() {
        return duration;
    }

    public int getListeners() {
        return listeners;
    }

    public int getPlaycount() {
        return playcount;
    }

    public TrackArtist getTrackArtist() {
        return trackArtist;
    }

    public TrackAlbum getTrackAlbum() {
        return trackAlbum;
    }

    public Wiki getWiki() {
        return wiki;
    }
}
