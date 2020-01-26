package com.deromang.daggersample.ui.detail;


import android.support.v4.app.Fragment;
import android.widget.ImageView;
import android.widget.TextView;

import com.deromang.daggersample.R;
import com.deromang.daggersample.deromang.modules.presentation.main.DetailComponent;
import com.deromang.daggersample.deromang.modules.presentation.main.DetailModule;
import com.deromang.daggersample.domain.data.Photo;
import com.deromang.daggersample.presentation.detail.DetailPresenter;
import com.deromang.daggersample.presentation.detail.DetailView;
import com.deromang.daggersample.ui.BaseFragment;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends BaseFragment implements DetailView {

    @Inject
    DetailPresenter presenter;

    @BindView(R.id.ivTitle)
    ImageView ivTitle;

    @BindView(R.id.tvTitle)
    TextView tvTitle;

    @BindView(R.id.tvDescription)
    TextView tvDescription;

    @BindView(R.id.tvAuthor)
    TextView tvAuthor;
    @BindView(R.id.tvDate)
    TextView tvDate;
    Unbinder unbinder;

    private Photo photo;

    private DetailComponent component;


    public DetailFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance(Photo photo) {
        DetailFragment fragment = new DetailFragment();
        fragment.photo = photo;
        return fragment;
    }


    @Override
    public int getLayoutResId() {
        return R.layout.fragment_detail;
    }

    @Override
    protected void prepareInjection() {
        component = getActivityComponent()
                .detailComponent()
                .detailModule(new DetailModule())
                .build();

        component.inject(this);

        presenter.setView(this);

        setupView();

    }

    @OnClick(R.id.ivBack)
    public void onClickBack() {
        getActivity().onBackPressed();
    }

    private void setupView() {
        Picasso.get().load(photo.getThumbnail()).into(ivTitle);
        tvTitle.setText(photo.getTitle());
        tvAuthor.setText(photo.getOwnername());
        tvDate.setText(photo.getDate());
        if (photo.getDescription() != null)
            tvDescription.setText(photo.getDescription().getContent());
    }


    @Override
    public void onResume() {
        super.onResume();
        hideToolbar();
    }
}
