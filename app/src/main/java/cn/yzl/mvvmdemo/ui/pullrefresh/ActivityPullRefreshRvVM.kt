package cn.yzl.mvvmdemo.ui.pullrefresh

import android.content.Context
import android.databinding.ObservableArrayList
import android.databinding.ObservableLong
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import cn.yzl.mvvmdemo.base.BaseViewModel
import cn.yzl.mvvmdemo.databinding.adapter.PullRereshLayoutAttrAdapter
import cn.yzl.mvvmdemo.databinding.callback.SimpleListChagngedCallback
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

/**
 * Created by YZL on 2017/12/14.
 */
class ActivityPullRefreshRvVM(context: Context) : BaseViewModel(context) {
    var plState: ObservableLong = ObservableLong(PullRereshLayoutAttrAdapter.STATE_DEFAULT)

    var mDatas = ObservableArrayList<String>();

    var adapter: PlAdapter

    var layoutManager: RecyclerView.LayoutManager

    init {
        layoutManager = LinearLayoutManager(context)

        adapter = PlAdapter(context, mDatas)

        mDatas.addOnListChangedCallback(object : SimpleListChagngedCallback<ObservableArrayList<String>>() {
            override fun onChanged(p0: ObservableArrayList<String>?) {
                adapter.notifyDataSetChanged()
            }
        })
    }

    fun loadmore() {
        Observable
                .timer(3, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    mDatas.add(System.currentTimeMillis().toString())
                    plState.set(PullRereshLayoutAttrAdapter.STATE_LOADMORE_SUCESS)
                })
    }

    fun refresh() {
        Observable
                .timer(3, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    mDatas.clear()
                    mDatas.add("1111")
                    mDatas.add("1111")
                    mDatas.add("1111")
                    plState.set(PullRereshLayoutAttrAdapter.STATE_REFRESH_SUCESS)
                })
    }
}
