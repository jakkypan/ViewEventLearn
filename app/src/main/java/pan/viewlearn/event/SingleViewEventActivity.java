/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package pan.viewlearn.event;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * 测试onTouchEvent onTouchListener onClickListener的调用顺序
 *
 * Created by panhongchao on 15/12/13.
 */
public class SingleViewEventActivity extends Activity {

    TestViewGroup l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TestButton b = new TestButton(this);
        b.setOnTouchListener(new OnTouchListenerTest());
        b.setOnClickListener(new OnClickListenerTest());
        l = new TestViewGroup(this);
        l.addView(b);
        setContentView(l);
    }

    public class OnTouchListenerTest implements View.OnTouchListener  {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            l.requestDisallowInterceptTouchEvent(true);
            Log.e("view", "subview onTouch is called." + "   " + event.getAction());
            return true;
        }
    }

    public class OnClickListenerTest implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Log.e("view", "subview onClick is called.");
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("view", "activity onTouchEvent is called." + "   " + event.getAction());
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("view", "activity dispatchTouchEvent is called." + "   " + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }
}
