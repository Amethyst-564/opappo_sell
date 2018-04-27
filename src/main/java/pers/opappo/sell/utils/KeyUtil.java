package pers.opappo.sell.utils;

import java.util.Random;

/**
 * 索引约束工具类
 * Created by Luvoratorrrrry on 2018/4/9.
 */
public class KeyUtil {

    /**
     * 生成唯一主键
     * 格式：时间+随机数
     *
     * @return
     */
    public static synchronized String genUniqueKey() {

        Random random = new Random();
        //生成6位随机数
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
