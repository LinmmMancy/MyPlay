package com.atguigu.lmm.myplay.App;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Mancy_Lin on 2017-01-16.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);
    }
}
