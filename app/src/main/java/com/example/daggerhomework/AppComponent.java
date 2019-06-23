package com.example.daggerhomework;


import com.example.daggerhomework.view.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {DaggerNetModule.class, AppModule.class})
public interface AppComponent {
    void injectToBaseActivity(BaseActivity activity);
}
