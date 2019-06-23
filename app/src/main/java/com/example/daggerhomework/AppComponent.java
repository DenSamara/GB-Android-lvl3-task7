package com.example.daggerhomework;

import android.content.Context;

import com.example.daggerhomework.view.repo.details.RepoDetailsActivity;
import com.example.daggerhomework.view.repo.list.RepoListActivity;
import com.example.daggerhomework.view.user.UserDetailsActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {DaggerNetModule.class, AppModule.class})
public interface AppComponent {
    Context provideAppContext();

    void injectToRepoDetailsActivity(RepoDetailsActivity repoDetailsActivity);
    void injectToRepoListActivity(RepoListActivity repoListActivity);
    void injectToUserDetailsActivity(UserDetailsActivity userDetailsActivity);

}
