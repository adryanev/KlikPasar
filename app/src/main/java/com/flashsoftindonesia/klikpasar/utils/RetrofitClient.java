package com.flashsoftindonesia.klikpasar.utils;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.flashsoftindonesia.klikpasar.config.Config;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class RetrofitClient {

    private static Retrofit retrofit;

    public static Retrofit getClient(){
        if(retrofit == null){
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    Timber.i(message);
                }
            });
            interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);


            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .addNetworkInterceptor(new StethoInterceptor())
                    .build();

            retrofit = new Retrofit.Builder().baseUrl(Config.API_ENDPOINT).client(client).addConverterFactory(GsonConverterFactory.create()).build();
           return retrofit;
        }

        return retrofit;
    }
}
