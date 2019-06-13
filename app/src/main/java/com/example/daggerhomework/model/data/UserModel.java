package com.example.daggerhomework.model.data;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class UserModel {
    @Nullable
    @SerializedName("avatar_url")
    public String imageUrl;

    @Nullable
    public String login;
}
