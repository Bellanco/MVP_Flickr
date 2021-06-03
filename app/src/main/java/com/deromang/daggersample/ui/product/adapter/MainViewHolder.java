package com.deromang.daggersample.ui.product.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.deromang.daggersample.R;
import com.deromang.daggersample.domain.data.Photo;
import com.deromang.daggersample.ui.product.MainListener;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

class MainViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.ivTitle)
    ImageView ivTitle;

    @BindView(R.id.tvTitle)
    TextView tvTitle;

    @BindView(R.id.tvDescription)
    TextView tvDescription;

    @Inject
    public MainViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(final Photo photo, final MainListener listener) {
        Picasso.get().load(photo.getThumbnail()).placeholder(R.drawable.img_default).fit().centerCrop().into(ivTitle);
        tvTitle.setText(photo.getTitle());
        tvDescription.setText(photo.getOwnername());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(photo);
            }
        });
    }

}
