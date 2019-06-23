package com.example.daggerhomework.model.net;


import com.example.daggerhomework.model.data.RepoDetailsModel;
import com.example.daggerhomework.model.data.RepoModel;
import com.example.daggerhomework.model.data.UserModel;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Endpoints {

    @GET("/repositories")
    Flowable<List<RepoModel>> getReps();

    @GET("/repos/{user}/{repo}")
    Flowable<RepoDetailsModel> getRepoDetails(
            @Path("user") String user,
            @Path("repo") String repo
    );

    @GET("/users/{user}")
    Flowable<UserModel> getUser(
            @Path("user") String user
    );
}
