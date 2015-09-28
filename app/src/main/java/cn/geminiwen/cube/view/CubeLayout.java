package cn.geminiwen.cube.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BaseInterpolator;
import android.widget.FrameLayout;

import cn.geminiwen.cube.animation.CubeLeftOutAnimation;
import cn.geminiwen.cube.animation.CubeRightInAnimation;

/**
 * Created by geminiwen on 15/9/24.
 */
public class CubeLayout extends FrameLayout{

    private BaseInterpolator mInterpolator = new AccelerateDecelerateInterpolator();

    public CubeLayout(Context context) {
        this(context, null);
    }

    public CubeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CubeLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        View foregroundView = getChildAt(0);
        View backgroundView = getChildAt(1);

        CubeLeftOutAnimation cubeLeftOutAnimation = new CubeLeftOutAnimation();
        cubeLeftOutAnimation.setDuration(1000);
        cubeLeftOutAnimation.setFillAfter(true);

        CubeRightInAnimation cubeRightInAnimation = new CubeRightInAnimation();
        cubeRightInAnimation.setDuration(1000);
        cubeRightInAnimation.setFillAfter(true);

        foregroundView.startAnimation(cubeLeftOutAnimation);
        backgroundView.startAnimation(cubeRightInAnimation);
    }
}

