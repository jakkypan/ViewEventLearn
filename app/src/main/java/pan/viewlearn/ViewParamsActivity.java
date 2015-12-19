/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package pan.viewlearn;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by panhongchao on 15/12/9.
 */
public class ViewParamsActivity extends AppCompatActivity {
    Button view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(100, 100);
        params.gravity = Gravity.CENTER;
        layout.setLayoutParams(params);
        layout.setGravity(Gravity.CENTER);
        layout.setBackgroundColor(Color.GREEN);

        view = new Button(this);
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(20, 20);
        params2.gravity = Gravity.CENTER;
        view.setLayoutParams(params2);
        view.setGravity(Gravity.CENTER);
        view.setBackgroundColor(Color.RED);

        layout.addView(view);
        setContentView(layout);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        Log.e("view", "left: " + view.getLeft() + ", right: " + view.getRight() + ", top: " + view.getTop() + ", "
                + "bottom: " + view.getBottom() + ", x: " + view.getX() + ", y: " + view.getY() + ", tx: " + view
                .getTranslationX() + ", ty: " + view.getTranslationY());
    }
}
