package cn.yzl.mvvmdemo.glide;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.module.GlideModule;

import cn.yzl.mvvmdemo.costants.APPConstans;

/**
 * glide cache
 * Created by 伊泽 on 2017/5/17.
 */
public class GlideCache implements GlideModule {

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {

        builder.setBitmapPool(null);
        builder.setDiskCache(new DiskLruCacheFactory(APPConstans.getGlideCacheDir(context), APPConstans.GLIDE_DIS_CACHE_SIZE));
    }

    @Override
    public void registerComponents(Context context, Glide glide) {
    }
}
