package com.barseghyan_massa.nsi_prospect;

import android.app.Application;
import android.content.Context;
import android.util.Log;

public class MyApplication extends Application {

    private static MyApplication instance = null;

    public MyApplication() {
        instance = this;
    }

    public static Context getAppContext() {
        if (instance == null) {
            instance = new MyApplication();
        }
        return instance;
    }

}