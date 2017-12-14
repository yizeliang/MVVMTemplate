package cn.yzl.mvvmdemo.exception;


import android.widget.Toast;

import cn.yzl.mvvmdemo.MyApplication;

/**
 * Created by YZL on 2017/12/13.
 */
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        Toast.makeText(MyApplication.Companion.getInstance(), "崩溃了,看日志", Toast.LENGTH_SHORT).show();
    }

}
