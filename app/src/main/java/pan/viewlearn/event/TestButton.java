/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package pan.viewlearn.event;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * Created by panhongchao on 15/12/13.
 */
public class TestButton extends Button {

    public TestButton(Context context) {
        super(context);
    }

    public TestButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("view", "subview onTouchEvent is called." + "   " + event.getAction());
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e("view", "subview dispatchTouchEvent is called." + "   " + event.getAction());
        return super.dispatchTouchEvent(event);
    }
}