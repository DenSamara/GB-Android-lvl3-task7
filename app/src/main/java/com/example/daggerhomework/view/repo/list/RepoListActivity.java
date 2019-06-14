package com.example.daggerhomework.view.repo.list;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daggerhomework.R;
import com.example.daggerhomework.contracts.RepoListContract;
import com.example.daggerhomework.model.data.RepoModel;
import com.example.daggerhomework.presenter.RepoListPresenter;
import com.example.daggerhomework.view.repo.details.RepoDetailsActivity;
import com.example.daggerhomework.view.user.UserDetailsActivity;

import java.util.List;

public class RepoListActivity extends AppCompatActivity
        implements RepoListContract.View, RepoListAdapter.Listener {

    private RepoListContract.Presenter presenter;

    private RecyclerView feedList;

    private RepoListAdapter adapter = new RepoListAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repos);

        feedList = findViewById(R.id.feed_list);
        feedList.setAdapter(adapter);
        initPresenter();
    }

    private void initPresenter() {
        presenter = new RepoListPresenter(this);
        presenter.loadData();
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
    public void showRepos(List<RepoModel> list) {
        adapter.setItems(list);
    }

    @Override
    public void onRepoClick(String user, String repo) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.select_details)
                .setItems(R.array.details_type, (dialog, which) -> {
                    switch (which){
                        case 0: {
                            startActivity(UserDetailsActivity.getIntentInstantce(this, user));
                            break;
                        }
                        case 1: {
                            startActivity(RepoDetailsActivity.getIntentInstantce(this, user, repo));
                        }
                    }
                });
        builder.create().show();
    }
}
