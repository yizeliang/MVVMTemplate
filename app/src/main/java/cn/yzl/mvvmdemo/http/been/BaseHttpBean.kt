package cn.yzl.mvvmdemo.http.been

/**
 * Created by yize on 2017/9/14.
 */
open class BaseHttpBean {
    var status: String? = null
    var resultSize: Int = 0
    var errorMessage: String? = null
    var resultCode: Int = 0

    val isSucess: Boolean
        get() = resultCode == 1

    /**
     * 至少有一条数据才会返回true
     * 关于这条数据会不会为null.不考虑,为null的情况不会有
     */
    open val isDataSucess: Boolean
        get() = isSucess

    override fun toString(): String {
        return "{" +
                "status='" + status + '\'' +
                ", resultSize=" + resultSize +
                ", errorMessage='" + errorMessage + '\'' +
                ", resultCode=" + resultCode +
                '}'
    }

}
