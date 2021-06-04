package com.deromang.daggersample.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.TextView;

import com.deromang.daggersample.R;

public class BaseDialog extends Dialog {

    public static final int DIALOG_TYPE_WRONG = 2;
    public static final int DIALOG_TYPE_SUCCESS = 3;

    private AnimationSet mAnimIn, mAnimOut;
    private View mDialogView;
    private TextView tvTitle, tvContent;
    private Button btnPositive, btnNegative;
    private ConstraintLayout clContent;
    private onClickCommentsDialog onClickListener;
    private onClickCommentsDialogNegative onClickListenerNegative;

    private int mDialogType;
    private boolean mIsShowAnim;
    private CharSequence mTitle, mContent, mBtnText, mBtnTextNegative;

    public BaseDialog(Context context) {
        this(context, 0);
    }

    public BaseDialog(Context context, int theme) {
        super(context, R.style.Dialog);
        init();
    }

    private void init() {
        mAnimIn = AnimationLoader.getInAnimation(getContext());
        mAnimOut = AnimationLoader.getOutAnimation(getContext());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initListener();
    }

    private void initView() {
        View contentView = View.inflate(getContext(), R.layout.dialog_type, null);
        setContentView(contentView);

        clContent = contentView.findViewById(R.id.clContent);
        mDialogView = getWindow().getDecorView().findViewById(android.R.id.content);
        tvTitle = contentView.findViewById(R.id.tvTitle);
        tvTitle.setText(mTitle);
        tvContent = contentView.findViewById(R.id.tvContent);
        tvContent.setText(mContent);
        tvContent.setMovementMethod(new ScrollingMovementMethod());

        setButtons(contentView);

        if (mTitle == null)
            tvTitle.setVisibility(View.GONE);

        getDialogStyle(mDialogType);
    }

    private void setTextHtml(CharSequence mContent) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            tvContent.setText(Html.fromHtml(mContent.toString(), Html.FROM_HTML_MODE_COMPACT));
        else tvContent.setText(Html.fromHtml(mContent.toString()));
    }

    private void setButtons(View contentView) {
        btnPositive = contentView.findViewById(R.id.btnPositive);
        btnNegative = contentView.findViewById(R.id.btnNegative);

        btnPositive.setText(mBtnText);
        btnNegative.setText(mBtnTextNegative);

        btnNegative.setVisibility(mBtnTextNegative != null ? View.VISIBLE : View.GONE);
    }

    private void getDialogStyle(int mDialogType) {
        if (DIALOG_TYPE_WRONG == mDialogType) {
            clContent.setBackgroundColor(getContext().getResources().getColor(R.color.error));
            tvTitle.setTextColor(getContext().getResources().getColor(R.color.white));
            tvContent.setTextColor(getContext().getResources().getColor(R.color.white));
            btnNegative.setTextColor(getContext().getResources().getColor(R.color.white));
        } else if (DIALOG_TYPE_SUCCESS == mDialogType) {
            clContent.setBackgroundColor(getContext().getResources().getColor(R.color.success));
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        startWithAnimation(mIsShowAnim);
        Dialog dialog = this;
        int width = (int) (DisplayUtil.getScreenSize(getContext()).x * 0.9);
        int height = (int) (DisplayUtil.getScreenSize(getContext()).y * 0.7);
        dialog.getWindow().setLayout(width, height);
    }

    @Override
    public void dismiss() {
        dismissWithAnimation(mIsShowAnim);
    }

    private void startWithAnimation(boolean showInAnimation) {
        if (showInAnimation) {
            mDialogView.startAnimation(mAnimIn);
        }
    }

    private void dismissWithAnimation(boolean showOutAnimation) {
        if (showOutAnimation) {
            mDialogView.startAnimation(mAnimOut);
        } else {
            super.dismiss();
        }
    }

    private void initAnimListener() {
        mAnimOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mDialogView.post(() -> callDismiss());
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    private void initListener() {
        btnPositive.setOnClickListener(v -> {
            if (onClickListener != null) {
                onClickListener.onClickPositive(this);
            }
        });

        btnNegative.setOnClickListener(v -> {
            if (onClickListenerNegative != null) {
                onClickListenerNegative.onClickNegative(this);
            }
        });
        initAnimListener();
    }

    private void callDismiss() {
        super.dismiss();
    }

    public interface onClickCommentsDialog {
        void onClickPositive(BaseDialog dialog);
    }

    public interface onClickCommentsDialogNegative {
        void onClickNegative(BaseDialog dialog);
    }

    public BaseDialog setAnimationEnable(boolean enable) {
        mIsShowAnim = enable;
        return this;
    }

    public BaseDialog setTitleText(CharSequence title) {
        mTitle = title;
        return this;
    }

    public BaseDialog setContentText(CharSequence content) {
        mContent = content;
        return this;
    }

    public BaseDialog setDialogType(int type) {
        mDialogType = type;
        return this;
    }

    public BaseDialog setPositiveListener(CharSequence btnText, onClickCommentsDialog l) {
        mBtnText = btnText;
        return setPositiveListener(l);
    }

    public BaseDialog setPositiveListener(onClickCommentsDialog l) {
        onClickListener = l;
        return this;
    }

    public BaseDialog setNegativeListener(CharSequence btnText, onClickCommentsDialogNegative l) {
        mBtnTextNegative = btnText;
        return setNegativeListener(l);
    }

    public BaseDialog setNegativeListener(onClickCommentsDialogNegative l) {
        onClickListenerNegative = l;
        return this;
    }

}
