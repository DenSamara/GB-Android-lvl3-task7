package com.example.daggerhomework;

import android.content.Context;

import com.example.daggerhomework.model.net.Endpoins;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class DaggerNetModule {
    private Context context;
    private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

    public DaggerNetModule(Context context) {this.context = context;}

    @Provides
    Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(getUrl())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Provides
    Endpoins getUserEndpoints(Retrofit retrofit){
        return retrofit.create(Endpoins.class);
    }

    private String getUrl(){
        return "https://api.github.com";
    }
}