/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package pan.viewlearn.propertymove;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import pan.viewlearn.R;

/**
 * Created by panhongchao on 15/12/13.
 */
public class PropertyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        //设置无标题
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        //设置全屏
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.property_layout);
//        getSupportActionBar().hide();
    }
}
