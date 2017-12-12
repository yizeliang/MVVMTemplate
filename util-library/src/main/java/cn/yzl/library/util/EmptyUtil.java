package cn.yzl.library.util;

import android.text.TextUtils;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * 判断一切数据是否为空的工具类,可以后续添加
 * Created by YZL on 2017/6/19.
 */
public class EmptyUtil {
    /**
     * 是否为空
     *
     * @return
     */
    public static boolean isEmpty(TextView tv) {
        if (tv == null) {
            throw new NullPointerException("TextView 不能为空");
        }
        CharSequence text = tv.getText();
        if (TextUtils.isEmpty(text) || TextUtils.isEmpty(text.toString().trim())) {
            return true;
        }

        return false;
    }

    public static boolean isEmpty(Map map) {
        if (map == null
                || map.size() == 0) {
            return true;
        }
        return false;
    }


    public static boolean isEmpty(List list) {
        if (list == null
                || list.size() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isNoEmpty(List list) {
        if (list == null
                || list.size() == 0
                || list.get(0) == null) {
            return false;
        }
        return true;
    }

    public static boolean isEmpty(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence) || TextUtils.isEmpty(charSequence.toString().trim())) {
            return true;
        }
        return false;
    }
}
