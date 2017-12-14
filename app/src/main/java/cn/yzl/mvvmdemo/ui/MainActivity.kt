package cn.yzl.mvvmdemo.ui

import android.content.Intent
import android.databinding.DataBindingUtil
import android.databinding.ObservableArrayList
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import cn.yzl.mvvmdemo.R
import cn.yzl.mvvmdemo.base.BaseActivity
import cn.yzl.mvvmdemo.databinding.ActivityMainBinding
import cn.yzl.mvvmdemo.databinding.callback.SimpleListChagngedCallback

class MainActivity : BaseActivity() {

    lateinit var type:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var bind: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val vm = ActivityMainVM(this);
        vm.img.set("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1513060465&di=325408b00f1d4d788d0ee1de070d4c60&src=http://imgsrc.baidu.com/imgad/pic/item/32fa828ba61ea8d3d8d6c33f9c0a304e251f5810.jpg")
//        vm.img.set("")
        vm.adapter.set(ListAdapter(this, vm.data))

        vm.data.add("下拉刷新/上拉加载/recycleView")

        vm.data.addOnListChangedCallback(object : SimpleListChagngedCallback<ObservableArrayList<String>>() {
            override fun onChanged(p0: ObservableArrayList<String>?) {
                vm.adapter.get()?.notifyDataSetChanged()
            }
        })
        bind.demo = vm;

        bind.lv.setOnItemClickListener { adapterView: AdapterView<*>, view: View, position: Int, id: Long ->
            when (position) {
                0 -> {
                    startActivity(Intent(this@MainActivity, MainActivity::class.java))
                }
            }
        }
    }

}

