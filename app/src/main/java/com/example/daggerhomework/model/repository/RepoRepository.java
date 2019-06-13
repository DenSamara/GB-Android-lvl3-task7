package com.example.daggerhomework.model.repository;

import com.example.daggerhomework.model.data.RepoDetailsModel;
import com.example.daggerhomework.model.data.RepoModel;
import com.example.daggerhomework.model.data.UserModel;
import com.example.daggerhomework.model.net.Endpoins;
import com.example.daggerhomework.model.net.ServiceGenerator;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RepoRepository {
    private Endpoins endpoins;

    public RepoRepository(){
        endpoins = new ServiceGenerator().createService(Endpoins.class);
    }

    public Flowable<List<RepoModel>> getReps(){
        return endpoins.getReps()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    public Flowable<RepoDetailsModel> getRepoByNameAndUser(String user, String repo){
        return endpoins.getRepoDetails(user, repo)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
