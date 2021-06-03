package com.deromang.daggersample.ui.detail;


import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.deromang.daggersample.R;
import com.deromang.daggersample.deromang.modules.presentation.main.DetailComponent;
import com.deromang.daggersample.deromang.modules.presentation.main.DetailModule;
import com.deromang.daggersample.domain.data.Photo;
import com.deromang.daggersample.domain.data.detail.PhotoModel;
import com.deromang.daggersample.domain.data.url.Size;
import com.deromang.daggersample.presentation.detail.DetailPresenter;
import com.deromang.daggersample.presentation.detail.DetailView;
import com.deromang.daggersample.tools.DateUtils;
import com.deromang.daggersample.ui.BaseFragment;
import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

    @BindView(R.id.tvTitleDescription)
    TextView tvTitleDescription;

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

        presenter.requestData();

        getDetailImage();
    }

    private void getDetailImage() {
        presenter.getDetailImage(photo.getId(), photo.getSecret());
        presenter.getUrlImage(photo.getId());
    }

    @OnClick(R.id.ivBack)
    public void onClickBack() {
        getActivity().onBackPressed();
    }

    private void setupView(PhotoModel photo) {
        tvTitle.setText(photo.getTitle().getContent());
        tvAuthor.setText(photo.getOwner().getUsername());
        tvDate.setText(DateUtils.getDate(photo.getDates().getTaken()));
        tvDescription.setText(photo.getDescription().getContent());
        if (photo.getDescription().getContent().isEmpty()) {
            tvTitleDescription.setVisibility(View.GONE);
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        hideToolbar();
    }

    @Override
    public void showDetailPhoto(PhotoModel photo) {
        setupView(photo);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getContext(), getString(R.string.error), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showImages(List<Size> images) {
        Collections.sort(images, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Size) o2).getWidth().compareTo(((Size) o1).getWidth());
            }
        });
        Picasso.get().load(images.get(0).getSource()).placeholder(R.drawable.img_default).into(ivTitle);
    }
}
