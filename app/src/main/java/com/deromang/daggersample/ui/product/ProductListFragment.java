package com.deromang.daggersample.ui.product;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.deromang.daggersample.R;
import com.deromang.daggersample.deromang.modules.presentation.product.ProductListComponent;
import com.deromang.daggersample.deromang.modules.presentation.product.ProductListModule;
import com.deromang.daggersample.domain.data.Photo;
import com.deromang.daggersample.presentation.product.ProductListPresenter;
import com.deromang.daggersample.presentation.product.ProductListView;
import com.deromang.daggersample.ui.BaseFragment;
import com.deromang.daggersample.ui.product.adapter.MainAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductListFragment extends BaseFragment implements ProductListView {

    private ProductListComponent component;

    @Inject
    ProductListPresenter presenter;

    @BindView(R.id.rvMain)
    RecyclerView rvMain;

    @BindView(R.id.ivEmpty)
    ImageView ivEmpty;

    @BindView(R.id.tvEmpty)
    TextView tvEmpty;

    private MainAdapter adapter;

    private List<Photo> photoList = new ArrayList<>();


    public ProductListFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance() {
        return new ProductListFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void prepareInjection() {
        component = getActivityComponent()
                .productListComponent()
                .productListModule(new ProductListModule())
                .build();

        component.inject(this);

        presenter.setView(this);

        setupView();

    }

    private void setupView() {
        adapter = new MainAdapter(photoList, new MainListener() {
            @Override
            public void onItemClick(Photo photo) {
                presenter.goToDetails(photo);
            }
        });

        rvMain.setLayoutManager(new LinearLayoutManager(getActivity()));

        rvMain.setAdapter(adapter);

        presenter.requestData();

    }

    public void onChangeText(CharSequence value) {
        presenter.onTextChanged(value);
    }

    public void onClickCross() {
        showText();
    }

    @Override
    public void onResume() {
        super.onResume();
        showToolbar();
        if (!photoList.isEmpty()) {
            hideText();
        }
    }

    @Override
    public void notifyDataSetChanged(List<Photo> photoList) {
        adapter.clear();
        adapter.addAll(photoList);
        adapter.notifyDataSetChanged();
        if (photoList.size() > 0) {
            hideText();
        } else {
            showText();
        }
    }

    private void hideText() {
        tvEmpty.setVisibility(View.GONE);
        ivEmpty.setVisibility(View.GONE);
    }

    private void showText() {
        tvEmpty.setVisibility(View.VISIBLE);
        ivEmpty.setVisibility(View.VISIBLE);
    }
}
