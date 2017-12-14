package cn.yzl.mvvmdemo.ui.pullrefresh

import android.databinding.DataBindingUtil
import android.os.Bundle
import cn.yzl.mvvmdemo.R
import cn.yzl.mvvmdemo.base.BaseActivity
import cn.yzl.mvvmdemo.databinding.ActivityPullRefreshRvBinding
import com.jingchen.pulltorefresh.PullToRefreshLayout

class PullRefreshRvActivity : BaseActivity() {
    lateinit var bind: ActivityPullRefreshRvBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = DataBindingUtil.setContentView(this, R.layout.activity_pull_refresh_rv)
        var vm = ActivityPullRefreshRvVM(this)
        vm.mDatas.add("1111")
        vm.mDatas.add("222")
        vm.mDatas.add("1111")
        vm.mDatas.add("1111")
        bind.vm = vm

        bind.pl.setOnPullListener(object : PullToRefreshLayout.OnPullListener {
            override fun onLoadMore(pullToRefreshLayout: PullToRefreshLayout?) {
                bind.vm?.loadmore()
            }

            override fun onRefresh(pullToRefreshLayout: PullToRefreshLayout?) {
                bind.vm?.refresh()
            }
        })
    }
}
