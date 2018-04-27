package pers.opappo.sell.utils;

/**
 * Created by Luvoratorrrrry on 2018/4/16.
 */
public class MathUtil {

    private static final Double Money_Range = 0.01;

    /**
     * 比较两个金额是否相等，差值小于一定精度就视作相等
     * @param d1
     * @param d2
     * @return
     */
    public static Boolean equals(Double d1, Double d2) {
        Double result = Math.abs(d1 - d2);
        if(result<Money_Range) {
            return true;
        } else {
            return false;
        }
    }
}
