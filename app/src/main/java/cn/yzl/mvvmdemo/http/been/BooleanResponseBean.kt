package cn.yzl.mvvmdemo.http.been

/**
 * 单项判断返回
 * 只需要返回正确或者失败
 * Created by yize on 2017/9/14.
 */
class BooleanResponseBean : ListHttpResponseWrapper<Boolean>() {
    val isBoolSucess: Boolean
        get() = isDataSucess && wapperData!![0]
}
