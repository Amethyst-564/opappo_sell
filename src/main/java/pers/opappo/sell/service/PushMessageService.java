package pers.opappo.sell.service;

import pers.opappo.sell.dto.OrderDTO;

/**
 * 消息推送
 * Created by Luvoratorrrrry on 2018/4/24.
 */
public interface PushMessageService {

    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
