package com.example.daggerhomework.contracts;

import com.example.daggerhomework.model.data.RepoModel;

import java.util.List;

public interface RepoListContract {
    interface View {
        void startLoading();
        void finishLoading();
        void showError(String string);
        void showRepos(List<RepoModel> list);
    }

    interface Presenter {
        void loadData();
    }
}
