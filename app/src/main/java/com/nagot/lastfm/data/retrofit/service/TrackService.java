package com.nagot.lastfm.data.retrofit.service;

import com.nagot.lastfm.model.TrackInfoResponse;
import com.nagot.lastfm.model.TrackResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by IanNagot on 16/03/2018.
 */

public interface TrackService {
    @GET("?method=track.search&format=json")
    Single<TrackResponse> getTrack(@Query("track") String track,
                                   @Query("api_key") String apiKey);

    @GET("?method=track.getInfo&format=json")
    Single<TrackInfoResponse> getTrackInfo(@Query("track") String track,
                                           @Query("artist") String artist,
                                           @Query("api_key") String apiKey);
}
