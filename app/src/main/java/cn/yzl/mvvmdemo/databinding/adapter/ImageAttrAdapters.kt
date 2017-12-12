package cn.yzl.mvvmdemo.databinding.adapter

import android.databinding.BindingAdapter
import android.graphics.drawable.Drawable
import android.widget.ImageView
import cn.yzl.library.util.EmptyUtil
import cn.yzl.mvvmdemo.R
import com.bumptech.glide.Glide

/**
 * Created by YZL on 2017/12/12.
 */
object ImageAttrAdapters {
    @JvmStatic
    @BindingAdapter(value = arrayOf("imgUrl", "placeHolder", "error", "empty"),
            requireAll = false)
    fun ImageUrlAdapter(view: ImageView, url: String,
                        placehoder: Drawable = view.context.resources.getDrawable(R.drawable.img_loading),
                        error: Drawable = view.context.resources.getDrawable(R.drawable.img_error),
                        emptyImg: Drawable = error) {
        if (EmptyUtil.isEmpty(url)) {
            view.setImageDrawable(emptyImg);
            return
        }
        Glide.with(view.context)
                .load(url)
                .asBitmap()
                .centerCrop()
                .placeholder(placehoder)
                .error(error)
                .into(view)
    }



}


