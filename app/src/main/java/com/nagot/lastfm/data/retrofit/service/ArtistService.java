package com.nagot.lastfm.data.retrofit.service;

import com.nagot.lastfm.model.ArtistResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by IanNagot on 16/03/2018.
 */

public interface ArtistService {
    @GET("?method=artist.search&format=json")
    Single<ArtistResponse> getArtists(@Query("artist") String artist,
                                      @Query("api_key") String apiKey);
}
