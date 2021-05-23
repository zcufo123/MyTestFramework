package com.test.mytestframework.application;

import android.app.Application;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class MyTestApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
