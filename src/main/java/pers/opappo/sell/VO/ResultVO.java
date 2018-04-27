package pers.opappo.sell.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * http请求返回的最外层对象
 * Created by Luvoratorrrrry on 2018/4/6.
 */
@Data
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = 477655776353929243L;

    //错误码
    private Integer code;

    //提示信息
    private String msg;

    //返回的具体内容
    private T data;
}
