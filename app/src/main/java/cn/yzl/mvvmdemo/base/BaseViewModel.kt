package cn.yzl.mvvmdemo.base

import android.content.Context
import android.databinding.BaseObservable
import android.databinding.Bindable

/**
 * Created by YZL on 2017/12/8.
 */
open class BaseViewModel(open var context: Context) : BaseObservable() {
}
