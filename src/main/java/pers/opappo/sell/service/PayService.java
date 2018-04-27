package pers.opappo.sell.service;

import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;
import pers.opappo.sell.dto.OrderDTO;

/**
 * Created by Luvoratorrrrry on 2018/4/14.
 */
public interface PayService {

    PayResponse create(OrderDTO orderDTO);

    PayResponse notify(String notifyData);

    RefundResponse refund(OrderDTO orderDTO);
}
