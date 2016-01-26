/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package pan.viewlearn.propertymove;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import pan.viewlearn.ViewApp;

/**
 * Created by panhongchao on 15/12/12.
 */
public class MyAnimView extends View {
    public static final float RADIUS = 50f;
    private Point currentPoint;
    private Paint mPaint;

    public MyAnimView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (currentPoint == null) {
            currentPoint = new Point(RADIUS, RADIUS);
            drawCircle(canvas);
            startAnimation();
        } else {
            drawCircle(canvas);
        }
    }

    private void drawCircle(Canvas canvas) {
        float x = currentPoint.getX();
        float y = currentPoint.getX();
        canvas.drawCircle(x, y, RADIUS, mPaint);
    }

    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        mPaint.setColor(Color.parseColor(color));
        invalidate();
    }

    private void startAnimation() {
////        WindowManager wm = (WindowManager) getContext()
////                .getSystemService(Context.WINDOW_SERVICE);
//        Point startPoint = new Point(RADIUS, RADIUS);
//        Point endPoint = new Point(ViewApp.mWidth - RADIUS, ViewApp.mHeight - RADIUS);
//        ValueAnimator animator = ValueAnimator.ofObject(new PointEvaluator(), startPoint, endPoint);
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                currentPoint = (Point) animation.getAnimatedValue();
//                invalidate();
//            }
//        });
//        animator.setDuration(5000);
//        animator.start();


        Point startPoint = new Point(RADIUS, RADIUS);
        Point endPoint = new Point(getWidth() - RADIUS, getHeight() - RADIUS);
        ValueAnimator anim = ValueAnimator.ofObject(new PointEvaluator(), startPoint, endPoint);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentPoint = (Point) animation.getAnimatedValue();
                invalidate();
            }
        });
        anim.setInterpolator(new DecelerateAccelerateInterpolator());
        ObjectAnimator anim2 = ObjectAnimator.ofObject(this, "color", new ColorEvaluator(),
                "#0000FF", "#FF0000");
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(anim).with(anim2);
        animSet.setDuration(5000);
        animSet.start();
    }
}
