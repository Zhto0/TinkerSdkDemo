package com.stan.tinkersdkdemo;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;

import java.io.File;

import androidx.appcompat.app.AppCompatActivity;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "tinkertest";
    private String mPatchDir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView mText = findViewById(R.id.text);
        findViewById(R.id.btn).setOnClickListener(this);
        requestPermission();

        Log.d(TAG, getDir("tpatch", MODE_PRIVATE).getAbsolutePath());
        makeDir();

        //热修复修改点：文本替换
        //mText.setText("出现bug了");
        mText.setText("修复bug了");

    }

    /**
     * 动态申请权限
     */
    public void requestPermission() {

        String[] perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE};
        if (!EasyPermissions.hasPermissions(this, perms)) {
            // Do not have permissions, request them now
            EasyPermissions.requestPermissions(this, "请开启您的定位和读写文件权限",
                    11, perms);
        }
    }

    /**
     * 创建保存patch包的文件夹
     */
    public void makeDir() {
        ///sdcard/Android/data/com.stan.tinkersdkdemo/cache/tpatch
        mPatchDir = getExternalCacheDir().getAbsolutePath() + "/tpatch/";
        //创建文件夹
        File file = new File(mPatchDir);
        if (!file.exists()) {
            file.mkdir();
            Log.d(TAG, "create tpatch dir");
        }
    }

    @Override
    public void onClick(View v) {
        loadPatch();
    }

    /**
     * 加载patch包
     */
    public void loadPatch() {
        String patch = mPatchDir.concat("patch_signed.apk");
        if (Tinker.isTinkerInstalled()) {
            Log.d(TAG, "loadPath:" + patch);
            TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(), patch);
        }
    }
}
