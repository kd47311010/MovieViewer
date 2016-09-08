package com.namhyun.movieviewerassist;

import android.support.annotation.Nullable;

import com.namhyun.movieviewerassist.services.KobisApiService;
import com.namhyun.movieviewerassist.services.TheMovieApiService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    @Nullable
    public static <S> S createService(Class<S> serviceClass) {
        String baseUrl = null;
        if (KobisApiService.class.isAssignableFrom(serviceClass)) {
            baseUrl = KobisApiService.BASE_URL;
        } else if (TheMovieApiService.class.isAssignableFrom(serviceClass)) {
            baseUrl = TheMovieApiService.BASE_URL;
        }

        if (baseUrl == null)
            return null;

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.client(client).build();
        return retrofit.create(serviceClass);
    }
}
