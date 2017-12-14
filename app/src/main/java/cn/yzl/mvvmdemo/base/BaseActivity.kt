package cn.yzl.mvvmdemo.base

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import kotlin.concurrent.thread

/**
 * Created by YZL on 2017/12/13.
 */
open class BaseActivity : AppCompatActivity() {

    val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun async(display: Long = 0L, block: () -> Unit) {
        thread(start = true) {
            Thread.sleep(display)
            block()
        }
    }

    fun uiThread(block: () -> Unit) {
        if (isFinishing)
            return
        runOnUiThread(block)
    }


    override fun onDestroy() {
        handler.removeCallbacksAndMessages(null)
        super.onDestroy()
    }
}