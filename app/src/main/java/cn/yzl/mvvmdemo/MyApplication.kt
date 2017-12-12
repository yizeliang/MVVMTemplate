package cn.yzl.mvvmdemo

import android.app.Application
import cn.yzl.library.util.EnvConfig
import com.orhanobut.logger.LogLevel
import com.orhanobut.logger.Logger
import kotlin.properties.Delegates

/**
 * Created by YZL on 2017/12/11.
 */
class MyApplication : Application() {
    companion object {
        var instance: MyApplication by Delegates.notNull<MyApplication>()
            get
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        EnvConfig.setDebug(BuildConfig.DEBUG)
        Logger.init(resources.getString(R.string.app_name_en)).methodCount(3).logLevel(if (EnvConfig.isDebug()) LogLevel.FULL else LogLevel.NONE)

    }
}
