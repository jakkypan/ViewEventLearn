/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package pan.viewlearn;

import android.app.Application;
import android.content.Context;
import android.view.WindowManager;

/**
 * Created by panhongchao on 15/12/13.
 */
public class ViewApp extends Application {
    public static int mHeight;
    public static int mWidth;

    @Override
    public void onCreate() {
        super.onCreate();

        WindowManager wm = (WindowManager) this.getApplicationContext()
                .getSystemService(Context.WINDOW_SERVICE);

        mHeight = wm.getDefaultDisplay().getHeight();
        mWidth = wm.getDefaultDisplay().getWidth();
    }
}
