package com.example.daggerhomework.presenter;

import com.example.daggerhomework.contracts.RepoListContract;
import com.example.daggerhomework.model.data.RepoModel;
import com.example.daggerhomework.model.repository.RepoRepository;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

public class RepoListPresenter implements RepoListContract.Presenter, Subscriber<List<RepoModel>> {

    private RepoRepository repository;
    private RepoListContract.View view;

    public RepoListPresenter(RepoListContract.View view) {
        this.view = view;
        repository = new RepoRepository();
    }

    @Override
    public void onSubscribe(Subscription s) {
        s.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(List<RepoModel> repoModels) {
        view.showRepos(repoModels);
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
        repository.getReps().subscribe(this);
    }
}
