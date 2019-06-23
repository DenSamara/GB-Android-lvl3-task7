package com.example.daggerhomework.model.repository;

import com.example.daggerhomework.model.data.RepoDetailsModel;
import com.example.daggerhomework.model.data.RepoModel;
import com.example.daggerhomework.model.net.Endpoints;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RepoRepository {
    private Endpoints endpoints;

    public RepoRepository(Endpoints endpoints){
        this.endpoints = endpoints;
    }

    public Flowable<List<RepoModel>> getReps(){
        return endpoints.getReps()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    public Flowable<RepoDetailsModel> getRepoByNameAndUser(String user, String repo){
        return endpoints.getRepoDetails(user, repo)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
