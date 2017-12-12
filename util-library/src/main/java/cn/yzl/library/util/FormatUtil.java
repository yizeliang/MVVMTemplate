package cn.yzl.library.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author JingYang
 * @version create time：2016-1-5 上午10:06:43
 */
public class FormatUtil {
    public static String formatDouble(Double d, String formate) {
        if (d == null) {
            return "0";
        }
        DecimalFormat format = new DecimalFormat(formate);
        return format.format(d);
    }

    public static String formatFloat(Float f, String formate) {
        if (f == null) {
            return "0";
        }
        DecimalFormat format = new DecimalFormat(formate);
        return format.format(f);
    }

    public static String formatFloat(BigDecimal f, String formate) {
        if (f == null) {
            return "0";
        }
        DecimalFormat format = new DecimalFormat(formate);
        return format.format(f);
    }

    public static String formatMoney(Float f) {
        if (f == null) {
            return "0";
        }
        DecimalFormat format = new DecimalFormat("#0.00");
        if (f % 1 == 0) {
            format.applyPattern("#0");
        }
        return format.format(f);
    }

    public static String formatMoney(Double f) {
        if (f == null) {
            return "0";
        }
        DecimalFormat format = new DecimalFormat("#0.00");
        if (f % 1 == 0) {
            format.applyPattern("#0");
        }
        return format.format(f);
    }

    public static String formatMoney(BigDecimal f) {
        if (f == null) {
            return "0";
        }
        DecimalFormat format = new DecimalFormat("#0.00");
        if (f.doubleValue() % 1 == 0) {
            format.applyPattern("#0");
        }
        return format.format(f);
    }

    public static String formatMoneyHavePoint(BigDecimal f) {
        if (f == null) {
            return "0";
        }
        DecimalFormat format = new DecimalFormat("#,###,###0.00");
        if (f.doubleValue() % 1 == 0) {
            format.applyPattern("#,###,###0");
        }
        return format.format(f);
    }

    /**
     * 两位小数
     * @param s
     * @return
     */
    public static String formatMoney2Point(String s) {
        if (s == null) {
            return "0.00";
        }
        DecimalFormat format = new DecimalFormat("#0.00");
        BigDecimal f = new BigDecimal(s);
        return format.format(f);
    }
    public static String formatMoney2Point(BigDecimal f) {
        if (f == null) {
            return "0.00";
        }
        DecimalFormat format = new DecimalFormat("#0.00");
        return format.format(f);
    }

    public static String formatMoney(String s) {
        if (s == null) {
            return "0.00";
        }
        DecimalFormat format = new DecimalFormat("#0.00");
        BigDecimal f = new BigDecimal(s);
        if (f.doubleValue() % 1 == 0) {
            format.applyPattern("#0");
        }
        return format.format(f);
    }

    public static String formatInt(Float f) {
        if (f == null) {
            return "0";
        }
        DecimalFormat format = new DecimalFormat("#0");
        return format.format(f);
    }

    public static String formatInt(Double f) {
        if (f == null) {
            return "0";
        }
        DecimalFormat format = new DecimalFormat("#0");
        return format.format(f);
    }

    public static String formatInt(BigDecimal f) {
        if (f == null) {
            return "0";
        }
        DecimalFormat format = new DecimalFormat("#0");
        return format.format(f);
    }
}