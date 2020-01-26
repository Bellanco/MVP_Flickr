package com.deromang.daggersample.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deromang.daggersample.deromang.modules.base.ActivityComponent;
import com.deromang.daggersample.presentation.BaseView;
import com.deromang.daggersample.ui.activity.MainActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author deromang.
 * @version 1.0.
 * @since 26/1/20.
 */
public abstract class BaseFragment extends Fragment implements BaseView {

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(getLayoutResId(), container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        prepareInjection();
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    public void showToolbar() {
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).showToolbar();
        }
    }

    public void hideToolbar() {
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).hideToolbar();
        }
    }

    protected abstract int getLayoutResId();

    protected abstract void prepareInjection();

    public final ActivityComponent getActivityComponent() {
        ActivityComponent component = null;
        if (getActivity() instanceof BaseActivity) {
            component = ((BaseActivity) getActivity()).getActivityComponent();
        }
        return component;
    }
}
