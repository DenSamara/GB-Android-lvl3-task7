package com.example.daggerhomework.model.repository;

import com.example.daggerhomework.model.data.UserModel;
import com.example.daggerhomework.model.net.Endpoints;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UserRepository {

    private Endpoints endpoints;

    public UserRepository(Endpoints endpoints){
        this.endpoints = endpoints;//new ServiceGenerator().createService(Endpoints.class);
    }

    public Flowable<UserModel> getUser(String user){
        return endpoints.getUser(user)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
