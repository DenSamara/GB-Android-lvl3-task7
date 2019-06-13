package com.example.daggerhomework.view.repo.list;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.daggerhomework.R;
import com.example.daggerhomework.model.data.RepoModel;

public class RepoViewHolder extends RecyclerView.ViewHolder {

    private View root;
    private TextView name;
    private TextView description;

    private RepoModel model;
    RepoListAdapter.Listener listener;

    private RepoViewHolder(View view) {
        super(view);
        root = view;
        root.setOnClickListener(view1 -> {
                    if (listener != null) {
                        listener.onRepoClick(model.owner.login, model.name);
                    }
                }
        );
        name = root.findViewById(R.id.name);
        description = root.findViewById(R.id.description);
    }

    public void bind(RepoModel model, RepoListAdapter.Listener listener) {
        this.listener = listener;
        this.model = model;
        name.setText(model.name);
        description.setText(model.description);
    }

    static RepoViewHolder create(LayoutInflater inflater, ViewGroup parent) {
        return new RepoViewHolder(inflater.inflate(R.layout.item_repo, parent, false));
    }
}
