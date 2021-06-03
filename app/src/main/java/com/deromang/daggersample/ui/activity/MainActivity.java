package com.deromang.daggersample.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.deromang.daggersample.R;
import com.deromang.daggersample.deromang.modules.presentation.main.MainComponent;
import com.deromang.daggersample.deromang.modules.presentation.main.MainModule;
import com.deromang.daggersample.presentation.main.MainPresenter;
import com.deromang.daggersample.presentation.main.MainView;
import com.deromang.daggersample.ui.BaseActivity;
import com.deromang.daggersample.ui.product.ProductListFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;


public class MainActivity extends BaseActivity implements MainView {

    @Inject
    MainPresenter presenter;

    @BindView(R.id.etFilter)
    EditText etFilter;

    @BindView(R.id.ivClose)
    ImageView ivClose;

    @BindView(R.id.tbMain)
    Toolbar tbMain;

    private MainComponent mainComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initComponent() {
        mainComponent = getActivityComponent()
                .mainComponent()
                .mainModule(new MainModule())
                .build();

        mainComponent.inject(this);

        presenter.setView(this);

        presenter.initialize();

        ivClose.setImageDrawable(getResources().getDrawable(R.drawable.ic_search));

    }

    @OnTextChanged(R.id.etFilter)
    void onChangeText(CharSequence value) {
        ivClose.setImageDrawable(getResources().getDrawable(R.drawable.ic_search));
        if (value.length() > 0) {
            ivClose.setImageDrawable(getResources().getDrawable(R.drawable.ic_close));
        }
        Fragment mFragment = getSupportFragmentManager().findFragmentById(R.id.container);
        if (mFragment instanceof ProductListFragment)
            ((ProductListFragment) mFragment).onChangeText(value);
    }

    @OnClick(R.id.ivClose)
    void onClickCross() {
        etFilter.setText("");
    }

    @Override
    public void onBackPressed() {
        presenter.onBackPressed();
    }

    public void showToolbar() {
        tbMain.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideToolbar() {
        tbMain.setVisibility(View.GONE);
    }

    public void clearResults() {
        etFilter.setText("");
    }
}
