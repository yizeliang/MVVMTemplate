package cn.yzl.mvvmdemo.databinding.callback

import android.databinding.ObservableList

/**
 * Created by YZL on 2017/12/12.
 */
abstract class SimpleListChagngedCallback<T : ObservableList<*>> : ObservableList.OnListChangedCallback<T>() {
    override fun onItemRangeChanged(t: T, i: Int, i1: Int) {
        onChanged(t)
    }

    override fun onItemRangeInserted(t: T, i: Int, i1: Int) {
        onChanged(t)
    }

    override fun onItemRangeMoved(t: T, i: Int, i1: Int, i2: Int) {
        onChanged(t)
    }

    override fun onItemRangeRemoved(t: T, i: Int, i1: Int) {
        onChanged(t)
    }
}
