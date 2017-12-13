package cn.yzl.mvvmdemo.http.been

import java.util.ArrayList

import cn.yzl.library.util.EmptyUtil

/**
 * 单层List返回
 * Created by YZL on 2017/11/24.
 */
open class ListHttpResponseWrapper<T> : BaseHttpBean() {
    /**
     * 请使用get方法,可以避免空指针
     */
    private var datas: List<T>? = null

    override val isDataSucess: Boolean
        get() = EmptyUtil.isNoEmpty(datas)

    val wapperData: List<T>?
        get() = if (isDataSucess) {
            datas
        } else {
            ArrayList()
        }


    val isDataNotNull: Boolean
        get() = datas != null

    fun setDatas(datas: List<T>) {
        this.datas = datas
    }
}
