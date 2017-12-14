package cn.yzl.mvvmdemo.ui.pullrefresh

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ObservableArrayList
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import cn.yzl.mvvmdemo.R
import cn.yzl.mvvmdemo.databinding.ItemPullRvBinding

/**
 * Created by YZL on 2017/12/14.
 */
class PlAdapter(var context: Context, var data: ObservableArrayList<String>) : RecyclerView.Adapter<PlAdapter.ViewHodle>() {
    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHodle?, position: Int) {
        holder?.bind?.name = data[position]
        holder?.bind?.executePendingBindings()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHodle {
        var bind: ItemPullRvBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.item_pull_rv, parent, false)
        return ViewHodle(bind)
    }


    class ViewHodle(var bind: ItemPullRvBinding) : RecyclerView.ViewHolder(bind.root) {

    }
}