package com.nagot.lastfm.data.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/**
 * Created by IanNagot on 16/03/2018.
 */

public class ServiceGenerator {
    private static final String API_BASE_URL = "";
    private static boolean isBuild = false;
    public static Retrofit retrofit;

    public static <S> S createService(Class<S> serviceClass) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = OkHttpClient.Builder()


    }

}
