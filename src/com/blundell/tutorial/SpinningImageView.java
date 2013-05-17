package com.blundell.tutorial;

import android.animation.TimeAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Simple CustomView that will rotate whatever image source you set
 */
public class SpinningImageView extends ImageView implements TimeAnimator.TimeListener {
    public static final int ROTATION_DELTA = 10;
    // This will tick every frame so you can update the view
    private TimeAnimator animatorTick;

    public SpinningImageView(Context context) {
        this(context, null);
    }

    public SpinningImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SpinningImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        animatorTick = new TimeAnimator();
        animatorTick.setTimeListener(this);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        animatorTick.start();
    }

    @Override
    public void onTimeUpdate(TimeAnimator animation, long totalTime, long deltaTime) {
        setRotationY(getRotationY() + ROTATION_DELTA);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        animatorTick.cancel();
    }
}
