package com.example.daggerhomework.view.repo.details;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.daggerhomework.R;
import com.example.daggerhomework.contracts.RepoDetailsContract;
import com.example.daggerhomework.model.data.RepoDetailsModel;
import com.example.daggerhomework.model.net.Endpoints;
import com.example.daggerhomework.model.net.ServiceGenerator;
import com.example.daggerhomework.model.repository.RepoRepository;
import com.example.daggerhomework.presenter.RepoDetailsPresenter;

public class RepoDetailsActivity extends AppCompatActivity implements RepoDetailsContract.View {

    private static final String USER_NAME = "extra_user_name";
    private static final String REPO_NAME = "extra_repo_name";

    private TextView name;
    private TextView description;
    private TextView issue;

    private RepoDetailsContract.Presenter presenter;

    public static Intent getIntentInstantce(Context context, String user, String repo) {
        Intent intent = new Intent(context, RepoDetailsActivity.class);
        intent.putExtra(USER_NAME, user);
        intent.putExtra(REPO_NAME, repo);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_details);
        bind();
        initPresenter();
    }

    private void bind(){
        name = findViewById(R.id.repo_name);
        description = findViewById(R.id.repo_description);
        issue = findViewById(R.id.repo_issue);
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
    public void showRepo(RepoDetailsModel model) {
        name.setText(model.name);
        description.setText(model.description);
        issue.setText(getString(R.string.issue_count, model.issuesCount));
    }

    private void initPresenter(){
        //Репозиторий в активити не особо нужен. TODO передать через сеттер в презентер
        //Но тогда мы можем забыть обязательный параметр.
        presenter = new RepoDetailsPresenter(this, new RepoRepository(new ServiceGenerator().createService(Endpoints.class)));
        String user = getIntent().getStringExtra(USER_NAME);
        String repo = getIntent().getStringExtra(REPO_NAME);
        presenter.setUser(user);
        presenter.setRepo(repo);
        presenter.loadData();
    }
}
