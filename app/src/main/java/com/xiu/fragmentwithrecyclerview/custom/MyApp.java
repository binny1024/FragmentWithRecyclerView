package com.xiu.fragmentwithrecyclerview.custom;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by xiu on 2016/10/25.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}