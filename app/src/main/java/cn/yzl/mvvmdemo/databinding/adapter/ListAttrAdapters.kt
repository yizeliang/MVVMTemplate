package cn.yzl.mvvmdemo.databinding.adapter

import android.databinding.BindingAdapter
import android.widget.AbsListView
import android.widget.BaseAdapter

/**
 * Created by YZL on 2017/12/12.
 */
object ListAttrAdapters {
    @JvmStatic
    @BindingAdapter("adapter")
    fun ImageUrlAdapter(view: AbsListView, adapter: BaseAdapter) {
        view.adapter = adapter;
    }
}


