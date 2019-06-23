package com.example.daggerhomework;

import android.app.Application;

public class MyApp extends Application {
    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .daggerNetModule(new DaggerNetModule())
                .build();
    }

    public static AppComponent getComponent() {
        return component;
    }
}
