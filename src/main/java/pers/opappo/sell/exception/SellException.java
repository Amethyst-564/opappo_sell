package pers.opappo.sell.exception;

import lombok.Getter;
import pers.opappo.sell.enums.ResultEnum;

/**
 * 异常
 * Created by Luvoratorrrrry on 2018/4/8.
 */
@Getter
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {

        //把message传到父类的构造方法里去
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
