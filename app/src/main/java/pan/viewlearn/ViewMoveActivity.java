/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package pan.viewlearn;


import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by panhongchao on 15/12/10.
 */
public class ViewMoveActivity extends Activity {
    Button button, b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        final LinearLayout layout = new LinearLayout(this);
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.MATCH_PARENT);
//        layout.setOrientation(LinearLayout.VERTICAL);
//
//        b = new Button(this);
//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                 button.scrollBy(0, -100);
//            }
//        });
//        LinearLayout.LayoutParams bp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
//                100);
//        bp.gravity = Gravity.TOP;
//        layout.addView(b, bp);
//
//        button = new Button(this);
//        LinearLayout.LayoutParams bp2 = new LinearLayout.LayoutParams(100, 100);
//        bp2.gravity = Gravity.CENTER;
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                b.scrollBy(0, 100);
//            }
//        });
//        layout.addView(button, bp2);
//
//        setContentView(layout, params);

        setContentView(R.layout.button_layout);

        final ImageView tv = (ImageView) findViewById(R.id.traditionView);
        final ImageView ov = (ImageView) findViewById(R.id.objectView);
        ov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ViewMoveActivity.this, "ok!!", Toast.LENGTH_SHORT).show();
            }
        });
        final ImageView pv = (ImageView) findViewById(R.id.paramsView);
        pv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ViewMoveActivity.this, "ok", Toast.LENGTH_SHORT).show();
            }
        });
        final ImageView tv2 = (ImageView) findViewById(R.id.traditionView2);
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ViewMoveActivity.this, "ok!", Toast.LENGTH_SHORT).show();
            }
        });

        final Button m = (Button) findViewById(R.id.button);
        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // paramsView
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(pv.getWidth(), pv.getHeight());
                pv.setPadding(pv.getPaddingLeft() + 10, pv.getPaddingTop(), pv.getPaddingRight(),
                        pv.getPaddingBottom());
                //                m.setLayoutParams(params);
                pv.requestLayout();
                ;

                // objectView
                int newLeft = ov.getLeft() + 110;
                ObjectAnimator.ofFloat(ov, "translationX", newLeft).start();

                // traditionView
                tv.scrollBy(-10, 0);

                // traditionView2
                final TranslateAnimation animation = new TranslateAnimation(0, 150, 0, 0);
                animation.setFillAfter(true);
                animation.setDuration(1000);
                tv2.setAnimation(animation);
                animation.startNow();
            }
        });


        View v = getWindow().getDecorView();
        View vv = ((ViewGroup) getWindow().getDecorView().findViewById(android.R.id.content)).getChildAt(0);
        int sv = 0;
    }
}
