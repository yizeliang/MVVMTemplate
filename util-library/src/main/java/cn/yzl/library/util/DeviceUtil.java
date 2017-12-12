package cn.yzl.library.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.provider.Settings;

import java.util.UUID;

public class DeviceUtil {

    private static String DEVICE_INFO;
    // DEV-DEBUG: 2017/11/23 测试环境
    public static final String DEGUG_ANDROID_ID = "yzl-debug";

    public static String getAndroidId(Context context) {
        if (EnvConfig.isDebug()) {
            return DEGUG_ANDROID_ID;
        }
        String id = android.os.Build.SERIAL;
        if (EmptyUtil.isEmpty(id)) {
            id = Settings.System.getString(context.getContentResolver(), Settings.System.ANDROID_ID);
        }
        if (EmptyUtil.isEmpty(id)) {
            id = UUID.randomUUID().toString();
        }
        return id;
    }

    /**
     * 返回版本名字
     * 对应build.gradle中的versionName
     *
     * @return
     */
    public static String getVersionName(Context context) {
        String versionName = "";
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            versionName = packInfo.versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return versionName;
    }

    /**
     * 返回版本号
     * 对应build.gradle中的versionCode
     *
     * @return
     */
    public static String getVersionCode(Context context) {
        String versionCode = "";
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            versionCode = String.valueOf(packInfo.versionCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return versionCode;
    }


    /**
     * 获取手机品牌
     *
     * @return
     */
    public static String getPhoneBrand() {
        return android.os.Build.BRAND;
    }

    /**
     * 获取手机型号
     *
     * @return
     */
    public static String getPhoneModel() {
        return android.os.Build.MODEL;
    }

    /**
     * 获取手机Android API等级（22、23 ...）
     *
     * @return
     */
    public static int getBuildLevel() {
        return android.os.Build.VERSION.SDK_INT;
    }

    /**
     * 获取手机Android 版本（4.4、5.0、5.1 ...）
     *
     * @return
     */
    public static String getBuildVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    /**
     * 获取当前App进程的id
     *
     * @return
     */
    public static int getAppProcessId() {
        return android.os.Process.myPid();
    }


    /**
     * 获取AndroidManifest.xml里 的值
     *
     * @param name
     * @return
     */
    public static String getMetaData(Context context, String name) {
        String value = null;
        try {
            ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            value = appInfo.metaData.getString(name, "");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static String getDeviceInfo(Context context) {
        if (!EmptyUtil.isEmpty(DEVICE_INFO)) {
            return DEVICE_INFO;
        }
        StringBuffer sb = new StringBuffer();
        try {
            sb.append("DeviceInfo:\t" + "\n");
            sb.append("VersionName:\t" + getVersionName(context) + "\n");
            sb.append("VersionCode:\t" + getVersionCode(context) + "\n");
            sb.append("PhoneBrand:\t" + getPhoneBrand() + "\n");
            sb.append("PhoneModel:\t" + getPhoneModel() + "\n");
            sb.append("APIVersion:\t" + getBuildVersion() + "\n");
            sb.append("APIVersionCode:\t" + getBuildLevel() + "\n");
            sb.append("VersionName:\t" + getVersionName(context) + "\n");
            sb.append("CHANNEL:\t" + getMetaData(context, "UMENG_CHANNEL") + "\n");
            DEVICE_INFO = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "DeviceInfo:" + "获取失败";

        }
        return DEVICE_INFO;
    }

    /**
     * 是否是oppo或者vivo手机
     *
     * @return
     */
    public boolean isOppoOrVivo() {
        String phoneBrand = getPhoneBrand();
        if (EmptyUtil.isEmpty(phoneBrand)) {
            return false;
        }
        return phoneBrand.contains("Oppo")
                || phoneBrand.contains("Oppo".toLowerCase())
                || phoneBrand.contains("Oppo".toUpperCase())
                || phoneBrand.contains("Vivo")
                || phoneBrand.contains("Vivo".toLowerCase())
                || phoneBrand.contains("Vivo".toUpperCase());
    }
}