package cn.yzl.mvvmdemo.costants;

import android.content.Context;
import android.os.Environment;

import java.io.File;

import cn.yzl.mvvmdemo.R;

/**
 * App一些常量配置
 * Created by 伊泽 on 2017/5/17.
 */
public class APPConstans {
    /**
     * glide 缓存路径
     */
    public static final String GLIDE_CACHE_DIR = "glide_cache";

    /**
     * glide 硬盘缓存大小
     */
    public static final int GLIDE_DIS_CACHE_SIZE = 100 * 1024 * 1024;

    /**
     * 照相机存储目录
     */
    public static final String CAMERA_CACHE_DIR = "camera_cache";

    /**
     * 获取应用数据主目录
     * /sss/ss 最后不带 /
     *
     * @param context
     * @return
     */
    public static String getRootDir(Context context) {
        File et = Environment.getExternalStorageDirectory();
        String path = et +
                File.separator +
                context.getString(R.string.app_name_en);
        return path;
    }

    public static String getCameraDirSimp(Context context) {
        return context.getString(R.string.app_name_en) + File.separator + CAMERA_CACHE_DIR;
    }


    public static String getCameraDir(Context context) {
        return getRootDir(context) + File.separator + CAMERA_CACHE_DIR;
    }

    public static String getGlideCacheDir(Context context) {
        return getRootDir(context) + File.separator + GLIDE_CACHE_DIR;
    }

}
