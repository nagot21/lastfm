package com.nagot.lastfm.data.retrofit.service;

import com.nagot.lastfm.model.AlbumResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by IanNagot on 16/03/2018.
 */

public interface AlbumService {
    @GET("?method=album.search&format=json")
    Single<AlbumResponse> getAlbum(@Query("album") String album,
                                   @Query("api_key") String apiKey);
}
