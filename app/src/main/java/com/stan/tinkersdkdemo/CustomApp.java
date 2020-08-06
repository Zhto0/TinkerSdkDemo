package com.stan.tinkersdkdemo;

import android.util.Log;

import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * Created by Stan on 2020-07-31.
 */
//public class CustomApp{}
public class CustomApp extends TinkerApplication {
    private final String TAG = "tinkertest";

    public CustomApp() {
        super(ShareConstants.TINKER_ENABLE_ALL,
                "com.stan.tinkersdkdemo.ProxyApp",
                "com.tencent.tinker.loader.TinkerLoader",
                false);

        Log.d(TAG, "CustomApp init");
    }

}
