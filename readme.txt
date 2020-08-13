
demo热修复使用说明：

1 执行assembleRelease打出release包，同时bakApk会生成副本文件
2 做app修复，同时调整tinker.gradle配置：
3 将bakApk会生成副本文件配置到如下path变量中
ext {
    tinkerEnable = true //tinker功能开关
   tinkerID = "1.0"
   tinkerOldApkPath = "${bakPath}/app-release-0806-14-18-36.apk"
   tinkerApplyMappingPath = "${bakPath}/"
   tinkerApplyResourcePath = "${bakPath}/app-release-0806-14-18-36-R.txt"
   tinkerBuildFlavorDirectory = "${bakPath}/"
}
4 执行tinkerPatchRelease生成patch差分包。
5 安装首次assembleRelease在bakApk中生成的apk，同时启动app，
这样会创建 /sdcard/tpatch目录。
6 将生成的patch_singed.apk push到上面的目录中。
7 点击加载patch。
8 重新启动app修复生效。


tinker.gradle在config文件夹下

patchSample附了基准包和修复包，可以直接使用


如果修复失败，则去掉源码和jar包，gradle中放开tinker maven库使用，是一定没问题的。可能我在迭代源码过程中难免会引入问题。
但是相关问题后续会修复。

博客文章:
https://www.jianshu.com/p/29031211f45b
