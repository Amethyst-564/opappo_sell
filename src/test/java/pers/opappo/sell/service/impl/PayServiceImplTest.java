package pers.opappo.sell.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.opappo.sell.dto.OrderDTO;
import pers.opappo.sell.service.OrderService;
import pers.opappo.sell.service.PayService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {

    @Autowired
    private PayService payService;

    @Autowired
    private OrderService orderService;

    @Test
    public void create() {
        OrderDTO orderDTO = orderService.findOne("1523877025464657821");
        payService.create(orderDTO);
    }

    //TODO 还没通过，待测
    @Test
    public void refund() {
        OrderDTO orderDTO = orderService.findOne("1523877025464657821");
        payService.refund(orderDTO);
    }
}