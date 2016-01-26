/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package pan.viewlearn.propertymove;

import android.animation.TimeInterpolator;

/**
 * Created by panhongchao on 16/1/26.
 */
public class DecelerateAccelerateInterpolator implements TimeInterpolator {

    @Override
    public float getInterpolation(float input) {
        float result;
        if (input <= 0.5) {
            result = (float) (Math.sin(Math.PI * input)) / 2;
        } else {
            result = (float) (2 - Math.sin(Math.PI * input)) / 2;
        }
        return result;
    }

}
