package cn.yzl.library.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by YZL on 2017/9/25.
 */
public class ValidateUtil {

    /**
     * 是否是车牌号
     *
     * @return true 是车牌号
     */
    public static boolean isCarId(String str) {
        if (EnvConfig.isDebug()) {
            // DEV-DEBUG: 2017/11/21 测试环境,取消校验
            return true;
        }
        str = str.toUpperCase();
        String regex = "^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$";
        return match(regex, str);
    }


    /**
     * 是否包含中文
     *
     * @param str 待验证的字符串
     * @return 含有中文返回true
     */
    public static boolean haveChinese(String str) {
        String regex = "^[^\\u4e00-\\u9fa5]{0,}$";
        return !match(regex, str);
    }

    /**
     * 验证邮箱
     *
     * @param str 待验证的字符串
     * @return 如果是符合的字符串, 返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean isEmail(String str) {
        String regex = "^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        return match(regex, str);
    }

    /**
     * 身份证号
     *
     * @param str
     * @return
     */
    public static boolean isIdCard(String str) {
        String regex = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
        return match(regex, str);
    }

    /**
     * 密码
     *
     * @param str
     * @return
     */
    public static boolean isPassword(String str) {
        String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,20}$";
        return match(regex, str);
    }

    /**
     *
     *支付密码
     * @param str
     * @return
     */
    public static boolean isPayPassword(String str) {
        String regex = "^\\d{6}$";
        return match(regex, str);
    }

    /**
     * 验证电话号码
     *
     * @param str 待验证的字符串
     * @return 如果是符合格式的字符串, 返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean IsTelephone(String str) {
        String regex = "^1[0-9]{10}$";
        return match(regex, str);
    }

    public static boolean match(String regex, String str) {
        if (str == null) {
            str = "";
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
