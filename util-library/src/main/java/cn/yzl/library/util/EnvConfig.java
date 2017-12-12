package cn.yzl.library.util;

/**
 * 是否是debug环境
 * Created by YZL on 2017/11/17.
 */
public class EnvConfig {
    private static boolean debug;

    public static boolean isDebug() {
        return debug;
    }

    public static void setDebug(boolean debug) {
        EnvConfig.debug = debug;
    }
}
