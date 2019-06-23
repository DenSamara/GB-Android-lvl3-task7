package com.example.daggerhomework;

import android.content.Context;
import android.net.ConnectivityManager;

import com.example.daggerhomework.model.net.Endpoints;
import com.example.daggerhomework.model.repository.RepoRepository;
import com.example.daggerhomework.model.repository.UserRepository;
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
    Endpoints getUserEndpoints(Retrofit retrofit){
        return retrofit.create(Endpoints.class);
    }

    @Provides
    ConnectivityManager getConnectivityManager() {
        return (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    @Provides
    UserRepository getUserRepo(){
        return new UserRepository(getUserEndpoints(getRetrofit()));
    }

    @Provides
    RepoRepository getRepoRepo(){
        return new RepoRepository(getUserEndpoints(getRetrofit()));
    }

    private String getUrl(){
        return "https://api.github.com";
    }
}
