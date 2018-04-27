package pers.opappo.sell.controller;

import com.lly835.bestpay.model.PayResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pers.opappo.sell.dto.OrderDTO;
import pers.opappo.sell.enums.ResultEnum;
import pers.opappo.sell.exception.SellException;
import pers.opappo.sell.service.OrderService;
import pers.opappo.sell.service.PayService;

import java.net.URLDecoder;
import java.util.Map;

/**
 * 支付
 * Created by Luvoratorrrrry on 2018/4/14.
 */
@Controller
//@RequestMapping("/pay")
@Slf4j
public class PayController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;

    @GetMapping("/pay")
    public ModelAndView index(@RequestParam("openid") String openid,
                              @RequestParam("orderId") String orderId,
                              @RequestParam("returnUrl") String returnUrl,
                              Map<String, Object> map) {
        log.info("openid={}", openid);

        //1.查订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        //发起支付

        //openid是从数据库里查的，不需要手动配置了
        //orderDTO.setBuyerOpenid(openid);
        PayResponse payResponse = payService.create(orderDTO);

        map.put("payResponse", payResponse);
        returnUrl = URLDecoder.decode(returnUrl);

        map.put("returnUrl", returnUrl);

        return new ModelAndView("pay/create", map);
    }

    //暂时不用
    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl") String returnUrl,
                               Map<String, Object> map) {

        //1.查订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        //发起支付
        PayResponse payResponse = payService.create(orderDTO);

        map.put("payResponse", payResponse);
        map.put("returnUrl", returnUrl);

        return new ModelAndView("pay/create", map);
    }

    @PostMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyData) {

        payService.notify(notifyData);

        //给微信返回处理结果(直接把xml代码贴在controller不美观，写到模板里好一些)
        return new ModelAndView("pay/success");
    }
}
