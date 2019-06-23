package com.example.daggerhomework;

import com.example.daggerhomework.view.repo.details.RepoDetailsActivity;
import com.example.daggerhomework.view.repo.list.RepoListActivity;
import com.example.daggerhomework.view.user.UserDetailsActivity;

import dagger.Component;

@Component(modules = {DaggerNetModule.class})
public interface AppComponent {
    void injectToRepoDetailsActivity(RepoDetailsActivity repoDetailsActivity);
    void injectToRepoListActivity(RepoListActivity repoListActivity);
    void injectToUserDetailsActivity(UserDetailsActivity userDetailsActivity);
}
