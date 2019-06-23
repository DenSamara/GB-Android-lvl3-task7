package com.example.daggerhomework.view.repo.list;

import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daggerhomework.R;
import com.example.daggerhomework.contracts.RepoListContract;
import com.example.daggerhomework.model.data.RepoModel;
import com.example.daggerhomework.model.data.UserModel;
import com.example.daggerhomework.model.net.Endpoints;
import com.example.daggerhomework.model.net.ServiceGenerator;
import com.example.daggerhomework.model.repository.RepoRepository;
import com.example.daggerhomework.presenter.RepoListPresenter;
import com.example.daggerhomework.view.ItemClickSupport;
import com.example.daggerhomework.view.repo.details.RepoDetailsActivity;
import com.example.daggerhomework.view.user.UserDetailsActivity;

import java.util.List;

import javax.inject.Inject;


public class RepoListActivity extends AppCompatActivity
        implements RepoListContract.View {

    private RepoListContract.Presenter presenter;

    private RecyclerView feedList;

    private RepoListAdapter adapter = new RepoListAdapter();

    @Inject
    Endpoints endpoints;

    @Inject
    ConnectivityManager connectivityManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repos);

        feedList = findViewById(R.id.feed_list);
        feedList.setAdapter(adapter);
        ItemClickSupport.addTo(feedList).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getBaseContext());
                builder.setTitle(R.string.select_details);
                builder.setItems(R.array.details_type, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0: {
                                RepoModel data = adapter.getItem(position);
                                UserModel owner = null;
                                if (data != null)
                                    owner = data.owner;
                                if (owner != null)
                                    startActivity(UserDetailsActivity.getIntentInstantce(getBaseContext(), owner.login));
                                break;
                            }
                            case 1: {
                                RepoModel data = adapter.getItem(position);
                                UserModel owner = null;
                                if (data != null)
                                    owner = data.owner;
                                if (owner != null)
                                    startActivity(RepoDetailsActivity.getIntentInstantce(getBaseContext(), owner.login, data.name));

                            }
                        }
                    }
                });
                builder.create().show();
            }
        });
        initPresenter();
    }

    private void initPresenter() {
        presenter = new RepoListPresenter(this, new RepoRepository(new ServiceGenerator().createService(Endpoints.class)));
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

}
