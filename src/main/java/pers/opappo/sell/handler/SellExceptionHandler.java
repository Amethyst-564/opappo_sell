package pers.opappo.sell.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pers.opappo.sell.VO.ResultVO;
import pers.opappo.sell.config.ProjectUrlConfig;
import pers.opappo.sell.exception.SellException;
import pers.opappo.sell.exception.SellerAuthorizeException;
import pers.opappo.sell.utils.ResultVOUtil;

/**
 * 异常捕获
 * Created by Luvoratorrrrry on 2018/4/24.
 */
@ControllerAdvice
public class SellExceptionHandler {

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    //拦截登录异常
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException() {
        return new ModelAndView("redirect:"
                .concat(projectUrlConfig.getWechatOpenAuthorize())
                .concat("/sell/wechat/qrAuthorize")
                .concat("?returnUrl=")
                .concat(projectUrlConfig.getSell())
                .concat("/sell/seller/login"));
    }

    @ResponseBody
    @ExceptionHandler(value = SellException.class)
    //可以修改响应status 如改为403 forbidden
    //@ResponseStatus(HttpStatus.FORBIDDEN)
    public ResultVO handlerSellException(SellException e) {

        return ResultVOUtil.error(e.getCode(), e.getMessage());

    }

}
