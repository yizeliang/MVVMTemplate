package cn.yzl.mvvmdemo

import android.databinding.DataBindingUtil
import android.databinding.ObservableArrayList
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import cn.yzl.mvvmdemo.databinding.ActivityMainBinding
import cn.yzl.mvvmdemo.databinding.callback.SimpleListChagngedCallback
import cn.yzl.mvvmdemo.model.ActivityMainVM
import com.orhanobut.logger.Logger

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var bind: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val vm = ActivityMainVM(this);
        vm.img.set("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1513060465&di=325408b00f1d4d788d0ee1de070d4c60&src=http://imgsrc.baidu.com/imgad/pic/item/32fa828ba61ea8d3d8d6c33f9c0a304e251f5810.jpg")
//        vm.img.set("")
        vm.adapter.set(ListAdapter(this, vm.data))
        for (i in 0..10) {
            vm.data.add("item--$i")
        }
        vm.data.addOnListChangedCallback(object : SimpleListChagngedCallback<ObservableArrayList<String>>() {
            override fun onChanged(p0: ObservableArrayList<String>?) {
                vm.adapter.get()?.notifyDataSetChanged()
                Logger.e("onChanged")
            }
        })
        bind.demo = vm;
        kotlin.run {  }
    }
}

