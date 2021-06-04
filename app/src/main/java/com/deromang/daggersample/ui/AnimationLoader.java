package com.deromang.daggersample.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;

/**
 * Created by Iria Sanchez on 2019-06-17.
 */
public class AnimationLoader {
    public AnimationLoader() {
    }

    public static AnimationSet getInAnimation(Context context) {
        AnimationSet in = new AnimationSet(context, (AttributeSet) null);
        AlphaAnimation alpha = new AlphaAnimation(0.0F, 1.0F);
        alpha.setDuration(150L);
        ScaleAnimation scale = new ScaleAnimation(0.5F, 1.0F, 0.5F, 1.0F, 1, 0.5F, 1, 0.5F);
        scale.setDuration(150L);
        in.addAnimation(alpha);
        in.addAnimation(scale);
        return in;
    }

    public static AnimationSet getOutAnimation(Context context) {
        AnimationSet out = new AnimationSet(context, (AttributeSet) null);
        AlphaAnimation alpha = new AlphaAnimation(1.0F, 0.0F);
        alpha.setDuration(150L);
        ScaleAnimation scale = new ScaleAnimation(1.0F, 0.5F, 1.0F, 0.5F, 1, 0.5F, 1, 0.5F);
        scale.setDuration(150L);
        out.addAnimation(alpha);
        out.addAnimation(scale);
        return out;
    }
}

