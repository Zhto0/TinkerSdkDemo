package com.mgtv.lib.tv.hotfix;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.tencent.tinker.entry.DefaultApplicationLike;
import com.tencent.tinker.lib.tinker.TinkerInstaller;

import androidx.multidex.MultiDex;

/**
 * Created by Stan on 2020-07-31.
 */
public class HotFixApplicationLike extends DefaultApplicationLike {
    private final String TAG = "tinkertest";

    public HotFixApplicationLike(Application application,
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
        Log.d(TAG, "HotFixApplicationLike init");
    }

    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);
        Log.d(TAG, "HotFixApplicationLike onBaseContextAttached");
        //使应用支持分包
        MultiDex.install(base);
        TinkerInstaller.install(this);//完成Tinker初始化
    }
}
