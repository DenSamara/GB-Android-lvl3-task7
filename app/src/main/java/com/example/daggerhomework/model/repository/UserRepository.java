package com.example.daggerhomework.model.repository;

import com.example.daggerhomework.model.data.UserModel;
import com.example.daggerhomework.model.net.Endpoins;
import com.example.daggerhomework.model.net.ServiceGenerator;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UserRepository {

    private Endpoins endpoins;

    public UserRepository(){
        endpoins = new ServiceGenerator().createService(Endpoins.class);
    }

    public Flowable<UserModel> getUser(String user){
        return endpoins.getUser(user)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
