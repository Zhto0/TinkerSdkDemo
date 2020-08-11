package com.stan.tinkersdkdemo;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.mgtv.lib.tv.hotfix.HotFixApplicationLike;

/**
 * Created by Stan on 2020-08-03.
 */

public class ProxyApp extends HotFixApplicationLike {
    private final String TAG = "tinkertest";

    public ProxyApp(Application application,
                    int tinkerFlags,
                    boolean tinkerLoadVerifyFlag,
                    long applicationStartElapsedTime,
                    long applicationStartMillisTime,
                    Intent tinkerResultIntent) {

        super(application,
                tinkerFlags,
                tinkerLoadVerifyFlag,
                applicationStartElapsedTime,
                applicationStartMillisTime,
                tinkerResultIntent);
        Log.d(TAG, "ProxyApp init");
    }

    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);
        Log.d(TAG, "ProxyApp onBaseContextAttached");
    }
}
