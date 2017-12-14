package cn.yzl.mvvmdemo.databinding.adapter

import android.databinding.BindingAdapter
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.support.annotation.IntDef
import android.widget.ImageView
import cn.yzl.library.util.EmptyUtil
import cn.yzl.mvvmdemo.R
import com.bumptech.glide.BitmapRequestBuilder
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.BitmapImageViewTarget

/**
 * Created by YZL on 2017/12/12.
 */
object ImageViewAttrAdapters {

    const val IMG_SCALE_FITCENTER = 1L;
    const val IMG_SCALE_CENTERCROP = 2L;
    const val IMG_SCALE_DEFAULT = 0L;

    const val IMG_BITMAP = 0L
    const val IMG_GIF = 1L

    @Retention(AnnotationRetention.SOURCE)
    @IntDef(IMG_SCALE_DEFAULT, IMG_SCALE_FITCENTER, IMG_SCALE_CENTERCROP)
    annotation class ImageScaleType

    @Retention(AnnotationRetention.SOURCE)
    @IntDef(IMG_BITMAP, IMG_GIF)
    annotation class ImageType


    @JvmStatic
    @BindingAdapter(value = arrayOf("bind_imgUrl", "bind_placeHolder", "bind_error", "bind_empty", "bind_glide_scale",
            "bind_image_type", "bind_target"),
            requireAll = false)
    fun ImageUrlAdapter(view: ImageView,
                        url: String?,
                        _placehoder: Drawable?,
                        _error: Drawable?,
                        emptyImg: Drawable?,
                        @ImageScaleType scaleType: Long? = IMG_SCALE_DEFAULT,
                        @ImageType imageType: Long? = IMG_BITMAP,
                        target: BitmapImageViewTarget?) {

        if (EmptyUtil.isEmpty(url)) {
            if (emptyImg != null) {
                view.setImageDrawable(emptyImg);
            }
            return
        }
        val load = Glide.with(view.context)
                .load(url!!)
        var img = if (imageType == IMG_BITMAP || imageType == null) load.asBitmap() else load.asBitmap()
        var scale: BitmapRequestBuilder<String, Bitmap>? = null
        if (scaleType != null) {
            when (scaleType) {
                IMG_SCALE_FITCENTER -> {
                    scale = img.fitCenter()
                }
                IMG_SCALE_CENTERCROP -> {
                    scale = img.centerCrop()
                }
            }
        }

        var request: BitmapRequestBuilder<String, Bitmap>

        var placehoder = _placehoder ?: view.context.resources.getDrawable(R.drawable.img_loading)
        var error = _error ?: view.context.resources.getDrawable(R.drawable.img_error)


        if (scale != null) {
            request = scale.placeholder(placehoder)
                    .error(error)
        } else {
            request = img.placeholder(placehoder)
                    .error(error)
        }
        if (target != null) {
            request.into(target)
        } else {
            request.into(view)
        }

    }


}


