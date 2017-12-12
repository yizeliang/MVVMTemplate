package cn.yzl.mvvmdemo.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;

import com.bumptech.glide.request.target.BitmapImageViewTarget;

/**
 * 圆形图片
 * Created by YZL on 2017/9/18.
 */
public class RoundImageViewTarget extends BitmapImageViewTarget {
    private Context context;

    public RoundImageViewTarget(ImageView view, Context context) {
        super(view);
        this.context = context;
    }

    @Override
    protected void setResource(Bitmap resource) {
        super.setResource(resource);
        RoundedBitmapDrawable circularBitmapDrawable =
                RoundedBitmapDrawableFactory.create(context.getResources(), resource);
        circularBitmapDrawable.setCircular(true);
        view.setImageDrawable(circularBitmapDrawable);
    }
}
