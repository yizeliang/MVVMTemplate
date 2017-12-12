package cn.yzl.mvvmdemo.model

import android.content.Context
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.ObservableArrayList
import android.databinding.ObservableField
import android.view.View
import cn.yzl.mvvmdemo.BR
import cn.yzl.mvvmdemo.ListAdapter

/**
 * Created by YZL on 2017/12/11.
 */
class ActivityMainVM(var context: Context) : BaseObservable() {
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

