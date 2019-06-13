package com.example.daggerhomework.presenter;

import com.example.daggerhomework.contracts.RepoDetailsContract;
import com.example.daggerhomework.model.data.RepoDetailsModel;
import com.example.daggerhomework.model.repository.RepoRepository;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class RepoDetailsPresenter implements RepoDetailsContract.Presenter, Subscriber<RepoDetailsModel> {

    private RepoRepository repository;
    private RepoDetailsContract.View view;
    private String user;
    private String repo;

    public RepoDetailsPresenter(RepoDetailsContract.View view) {
        this.view = view;
        repository = new RepoRepository();
    }

    @Override
    public void onSubscribe(Subscription s) {
        s.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(RepoDetailsModel repoDetailsModel) {
        view.showRepo(repoDetailsModel);
    }

    @Override
    public void onComplete() {
        view.finishLoading();
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        view.showError(e.getLocalizedMessage());
    }

    @Override
    public void loadData() {
        repository.getRepoByNameAndUser(user, repo).subscribe(this);
    }

    @Override
    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public void setRepo(String repo) {
        this.repo = repo;
    }
}
