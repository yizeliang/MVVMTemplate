package cn.yzl.library.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 日期操作工具类.
 *
 * @author shimiso
 */

public class DateUtil {

    /**
     * 英文简写（默认）如：2010-12-01
     */
    public static String FORMAT_YMD = "yyyy.MM.dd";
    public static String FORMAT_YMD2 = "yyyy年MM月dd日";

    public static String FORMAT_MD = "MM.dd";

    /**
     * 英文全称  如：2010-12-01 23:15:06
     */
    public static String FORMAT_YMDHMS = "yyyy-MM-dd HH:mm:ss";


    public static Calendar calendar = null;
    private static final String FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String FORMAT_YMDHM_POINT = "yyyy.MM.dd HH:mm";


    public static Date str2Date(String str) {
        return str2Date(str, null);
    }


    public static Date str2Date(String str, String format) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (format == null || format.length() == 0) {
            format = FORMAT;
        }
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * @param time 当前的时间
     * @return 格式到秒
     */
    public static String getTimeString(long time, String format) {
        return new SimpleDateFormat(format).format(time);
    }

    /**
     * 计算剩余时间
     *
     * @param data
     * @param type 0,等待卖家确认;1 等待确认收货
     * @return
     */
    public static String computeOrderData(Long data, int type) {
        long waitData = type == 0 ? 2 * 60 * 60 * 1000 : 7 * 24 * 60 * 60 * 1000;
        long overplus = waitData - (System.currentTimeMillis() - data);
        if (type == 1) {
            SimpleDateFormat frFormat = new SimpleDateFormat("d天HH小时mm分ss秒");
            frFormat.setTimeZone(TimeZone.getTimeZone("GMT+0"));
            return frFormat.format(overplus);
        } else {
            SimpleDateFormat frFormat = new SimpleDateFormat("H时m分ss秒");
            frFormat.setTimeZone(TimeZone.getTimeZone("GMT+0"));
            return frFormat.format(new Date(overplus));
        }
    }

    /**
     * 获取今天最晚时间
     *
     * @return
     */
    public static Calendar getNow23HTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar;
    }

    /**
     * 获取7天前最晚时间
     *
     * @return
     */
    public static Calendar get7Afater0HTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DAY_OF_MONTH, -6);
        return calendar;
    }
}
