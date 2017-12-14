package cn.yzl.mvvmdemo.databinding.adapter

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView

/**
 * Created by YZL on 2017/12/13.
 */
object RecycleViewAttrAdapter {
    @JvmStatic
    @BindingAdapter("bind_layout_manager")
    fun recyclerViewLayoutMnager(view: RecyclerView, layoutManager: RecyclerView.LayoutManager) {
        view.layoutManager = layoutManager;
    }

    @JvmStatic
    @BindingAdapter("bind_adapter")
    fun recyclerViewAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
        view.adapter = adapter;
    }

    @JvmStatic
    @BindingAdapter("bind_item_decoration")
    fun recyclerViewItemDecoration(view: RecyclerView, itemDecoration: RecyclerView.ItemDecoration) {
        view.addItemDecoration(itemDecoration)
    }
}
