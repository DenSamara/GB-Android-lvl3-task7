package com.example.daggerhomework.contracts;

import com.example.daggerhomework.model.data.UserModel;

public interface UserContract {
    interface View{
        void startLoading();
        void finishLoading();
        void showError(String string);
        void showUser(UserModel user);
    }

    interface Presenter {
        void setUser(String user);
        void loadData();
    }
}
