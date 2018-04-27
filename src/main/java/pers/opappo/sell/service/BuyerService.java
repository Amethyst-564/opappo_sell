package pers.opappo.sell.service;

import pers.opappo.sell.dto.OrderDTO;

/**
 * 买家
 * 查订单和判断openid的逻辑单独抽出来
 * 所有逻辑都放在service中，controller只调用service
 */
public interface BuyerService {

    //查询订单
    OrderDTO findOrderOne(String openid, String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid, String orderId);
}
