package com.example.daggerhomework.model.data;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class RepoDetailsModel {
    @Nullable
    public String description;
    @Nullable
    public String name;

    @SerializedName("open_issues_count")
    public int issuesCount = 0;

    public UserModel owner;
}
