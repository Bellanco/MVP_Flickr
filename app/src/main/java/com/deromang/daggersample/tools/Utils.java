package com.deromang.daggersample.tools;

import android.content.Context;

import com.deromang.daggersample.ui.BaseDialog;

public class Utils {

    private static BaseDialog buildDialog(Context context, int baseDialog, String title, String description) {
        BaseDialog dialog = new BaseDialog(context);
        if (!dialog.isShowing()) {
            dialog.setDialogType(baseDialog);
            dialog.setAnimationEnable(true);
            dialog.setTitleText(title);
            dialog.setContentText(description);
        }
        return dialog;
    }

    public static BaseDialog showDialog(Context context, int baseDialog, String title, String description, String positiveText, String negativeText, onDialogListener listener) {
        BaseDialog dialog = buildDialog(context, baseDialog, title, description);
        if (!dialog.isShowing()) {
            dialog.setPositiveListener(positiveText, promptDialog -> {
                listener.onClickPositive();
                dialog.dismiss();
            });
            dialog.setNegativeListener(negativeText, promptDialog -> {
                listener.onClickNegative();
                dialog.dismiss();
            });
            dialog.setOnDismissListener(promptDialog -> {
                // Empty
            });
            dialog.setOnCancelListener(promptDialog -> {
                listener.onClickNegative();
                dialog.dismiss();
            });
            dialog.show();
        }
        return dialog;
    }


    public interface onDialogListener {
        void onClickPositive();

        void onClickNegative();
    }
}
