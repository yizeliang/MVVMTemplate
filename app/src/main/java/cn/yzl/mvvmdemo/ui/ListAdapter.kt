package cn.yzl.mvvmdemo.ui

import android.content.Context
import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import cn.yzl.mvvmdemo.R
import cn.yzl.mvvmdemo.databinding.ItemListBinding

/**
 * Created by YZL on 2017/12/12.
 */
class ListAdapter(var context: Context, var data: MutableList<String>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var bind: ItemListBinding? = null;
        if (convertView == null) {
            bind = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_list, parent, false)
        } else {
            bind = DataBindingUtil.getBinding(convertView);
        }
        bind?.name = getItem(position)
        return bind!!.root
    }

    override fun getItem(position: Int): String {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.size
    }

}