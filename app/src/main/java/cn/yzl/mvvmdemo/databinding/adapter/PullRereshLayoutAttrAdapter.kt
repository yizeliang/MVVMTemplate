package cn.yzl.mvvmdemo.databinding.adapter

import android.databinding.BindingAdapter
import android.support.annotation.IntDef
import com.jingchen.pulltorefresh.PullToRefreshLayout

/**
 * Created by YZL on 2017/12/13.
 */
object PullRereshLayoutAttrAdapter {

    const val STATE_DEFAULT = -1L;

    const val STATE_AUTO_REFRESH = 0L;

    const val STATE_AUTO_LOADMORE = 2L;

    const val STATE_REFRESH_SUCESS = 3L;

    const val STATE_REFRESH_FAIL = 4L;

    const val STATE_LOADMORE_SUCESS = 5L;

    const val STATE_LOADMORE_NO_MORE = 6L;

    const val STATE_LOADMORE_FAIL = 7L;

    @Retention(AnnotationRetention.SOURCE)
    @IntDef(STATE_DEFAULT, STATE_AUTO_LOADMORE, STATE_AUTO_REFRESH,
            STATE_LOADMORE_NO_MORE, STATE_REFRESH_FAIL, STATE_REFRESH_SUCESS,
            STATE_LOADMORE_SUCESS, STATE_LOADMORE_FAIL)
    annotation class State

    @JvmStatic
    @BindingAdapter("bind_state", "bind_enable_refresh", "bind_enable_loadmore", requireAll = false)
    fun recyclerViewLayoutMnager(view: PullToRefreshLayout,
                                 @State state: Long = STATE_DEFAULT,
                                 refreshEnable: Boolean,
                                 loadmoreEnable: Boolean
    ) {
        view.setPullDownEnable(refreshEnable)
        view.setPullUpEnable(loadmoreEnable)

        when (state) {
            STATE_DEFAULT -> {
            }
            STATE_AUTO_LOADMORE -> {
                view.autoLoad()
            }
            STATE_AUTO_REFRESH -> {
                view.autoLoad()
            }
            STATE_REFRESH_SUCESS -> {
                view.refreshFinish(PullToRefreshLayout.SUCCEED)
            }
            STATE_REFRESH_FAIL -> {
                view.refreshFinish(PullToRefreshLayout.FAIL)
            }
            STATE_LOADMORE_SUCESS -> {
                view.loadmoreFinish(PullToRefreshLayout.SUCCEED)
            }
            STATE_LOADMORE_NO_MORE -> {
                view.loadmoreFinish(PullToRefreshLayout.NO_MORE)
            }
            STATE_LOADMORE_FAIL -> {
                view.loadmoreFinish(PullToRefreshLayout.FAIL)
            }
        }
    }
}
