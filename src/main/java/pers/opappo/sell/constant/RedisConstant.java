package pers.opappo.sell.constant;

/**
 * redis常量
 * Created by Luvoratorrrrry on 2018/4/23.
 */
public interface RedisConstant {

    String TOKEN_PREFIX = "token_%s";

    //2小时过期
    Integer EXPIRE = 7200;
}
