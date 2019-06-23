package com.example.daggerhomework.view.repo.list;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.daggerhomework.model.data.RepoModel;

import java.util.ArrayList;
import java.util.List;

public class RepoListAdapter extends RecyclerView.Adapter<RepoViewHolder> {

    private ArrayList<RepoModel> data = new ArrayList<>();
    private RepoViewHolder holder;

    RepoListAdapter(){
        super();
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return RepoViewHolder.create(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {
        holder.bind(data.get(position));
        this.holder = holder;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setItems(List<RepoModel> list){
        data.clear();
        data.addAll(list);
        notifyDataSetChanged();
    }

    public void addItems(List<RepoModel> list){
        int oldIndex=data.size();
        data.addAll(list);
        notifyItemRangeInserted(oldIndex, list.size());
    }

    public RepoModel getItem(int position){
        //TODO нужна проверка на выход за границы массива
        return data != null ? data.get(position) : null;
    }

    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }
}
