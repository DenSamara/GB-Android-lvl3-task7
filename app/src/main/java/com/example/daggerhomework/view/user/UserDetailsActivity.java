package com.example.daggerhomework.view.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.daggerhomework.R;
import com.example.daggerhomework.contracts.UserContract;
import com.example.daggerhomework.model.data.UserModel;
import com.example.daggerhomework.model.net.Endpoints;
import com.example.daggerhomework.model.net.ServiceGenerator;
import com.example.daggerhomework.model.repository.UserRepository;
import com.example.daggerhomework.presenter.UserPresenter;

public class UserDetailsActivity extends AppCompatActivity implements UserContract.View {

    private static final String USER_NAME = "extra_user_name";

    private TextView name;

    private ImageView image;

    private UserContract.Presenter presenter;

    public static Intent getIntentInstantce(Context context, String user) {
        Intent intent = new Intent(context, UserDetailsActivity.class);
        intent.putExtra(USER_NAME, user);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        bind();
        initPresenter();
    }

    private void bind(){
        name = findViewById(R.id.profile_name);
        image = findViewById(R.id.profile_image);
    }

    @Override
    public void startLoading() {
        //TODO start loading
    }

    @Override
    public void finishLoading() {
        //TODO finish loading
    }

    @Override
    public void showError(String string) {
        //TODO show error
    }

    @Override
    public void showUser(UserModel user) {
        name.setText(user.login);
        Glide.with(this)
                .load(user.imageUrl)
                .into(image);
    }

    private void initPresenter() {
        presenter = new UserPresenter(this, new UserRepository(new ServiceGenerator().createService(Endpoints.class)));
        String user = getIntent().getStringExtra(USER_NAME);
        presenter.setUser(user);
        presenter.loadData();
    }
}
