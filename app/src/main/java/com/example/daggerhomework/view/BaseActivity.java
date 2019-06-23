package com.example.daggerhomework.view;

import android.net.ConnectivityManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.daggerhomework.model.repository.RepoRepository;
import com.example.daggerhomework.model.repository.UserRepository;

import javax.inject.Inject;

public class BaseActivity extends AppCompatActivity {

    @Inject
    protected UserRepository userRepository;

    @Inject
    protected RepoRepository repoRepository;

    @Inject
    protected ConnectivityManager connectivityManager;
}
