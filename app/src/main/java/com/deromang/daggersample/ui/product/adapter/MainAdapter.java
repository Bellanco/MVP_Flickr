package com.deromang.daggersample.ui.product.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deromang.daggersample.R;
import com.deromang.daggersample.domain.data.Photo;
import com.deromang.daggersample.ui.product.MainListener;

import java.util.List;


public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

    private List<Photo> photoList;

    private MainListener listener;

    public MainAdapter(List<Photo> photoList, MainListener mainListener) {
        this.photoList = photoList;
        this.listener = mainListener;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup group, int viewType) {
        View v = LayoutInflater.from(group.getContext())
                .inflate(R.layout.fragment_main_adapter, group, false);
        return new MainViewHolder(v);

    }

    @Override
    public void onBindViewHolder(MainViewHolder viewHolder, int position) {
        viewHolder.bind(photoList.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }

    public void clear() {
        photoList.clear();
    }

    public void addAll(List<Photo> photos) {
        photoList.addAll(photos);
    }
}
