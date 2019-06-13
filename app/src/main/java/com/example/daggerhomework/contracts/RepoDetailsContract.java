package com.example.daggerhomework.contracts;

import com.example.daggerhomework.model.data.RepoDetailsModel;

public interface RepoDetailsContract {
    interface View {
        void startLoading();
        void finishLoading();
        void showError(String string);
        void showRepo(RepoDetailsModel model);
    }

    interface Presenter {
        void setUser(String user);
        void setRepo(String repo);
        void loadData();
    }
}