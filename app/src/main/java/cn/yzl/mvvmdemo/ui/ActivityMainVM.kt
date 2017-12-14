package cn.yzl.mvvmdemo.ui

import android.content.Context
import android.databinding.Bindable
import android.databinding.ObservableArrayList
import android.databinding.ObservableField
import android.view.View
import cn.yzl.mvvmdemo.BR
import cn.yzl.mvvmdemo.ui.ListAdapter
import cn.yzl.mvvmdemo.base.BaseViewModel

/**
 * Created by YZL on 2017/12/11.
 */
class ActivityMainVM(context: Context) : BaseViewModel(context) {
    var visible: Boolean = true
        @Bindable
        get
        set(value) {
            field = value
            notifyPropertyChanged(BR.visible)
        }
    var img = ObservableField<String>()

    var adapter = ObservableField<ListAdapter>()

    var data = ObservableArrayList<String>()

    fun onViewClick(v: View) {
        if (data.size > 0) {
            data.removeAt(data.size - 1)
        }
    }
}

