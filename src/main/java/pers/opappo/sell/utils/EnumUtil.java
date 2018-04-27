package pers.opappo.sell.utils;

import pers.opappo.sell.enums.CodeEnum;

/**
 * 枚举工具类
 * Created by Luvoratorrrrry on 2018/4/19.
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {

        for(T each: enumClass.getEnumConstants()) {
            if(code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
