/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package pan.viewlearn.propertymove;

import android.animation.TypeEvaluator;
import pan.viewlearn.ViewApp;

/**
 * Created by panhongchao on 15/12/12.
 */
public class PointEvaluator implements TypeEvaluator<Point> {

    // result = x0 + t * (x1 - x0)
    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {
        float newX = startValue.getX() + fraction * (endValue.getX() - startValue.getX());
//        float newY = startValue.getY() + fraction * (endValue.getY() - startValue.getY());
        float newY = (ViewApp.mHeight / ViewApp.mWidth) * newX;
        return new Point(newX, newY);
    }
}
