/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package pan.viewlearn.touchdelegate;

import android.graphics.Rect;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import pan.viewlearn.R;

/**
 * Created by panhongchao on 15/12/16.
 */
public class TouchDelegateLearn extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.touch_delegate);

        final View child = findViewById(R.id.child);
        final View parent = findViewById(R.id.parent);

        parent.post(new Runnable() {
            @Override
            public void run() {
                Rect rc = new Rect();
                child.getHitRect(rc);
                rc.bottom += 150;
                parent.setTouchDelegate(new TouchDelegate(rc, child));
            }
        });


        child.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                Log.i("ray", String.format("action=%d, x:%f,y=%f", motionEvent.getAction(), motionEvent.getX(), motionEvent.getY()));

                if(motionEvent.getAction()== MotionEvent.ACTION_DOWN){
                    return true;
                }else{
                    return false;
                }
            }
        });
    }

}