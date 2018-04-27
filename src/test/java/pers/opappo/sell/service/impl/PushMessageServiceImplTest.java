package pers.opappo.sell.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.opappo.sell.dto.OrderDTO;
import pers.opappo.sell.service.OrderService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PushMessageServiceImplTest {

    @Autowired
    private PushMessageServiceImpl pushMessageService;

    @Autowired
    private OrderService orderService;

    @Test
    public void orderStatus() {

        OrderDTO orderDTO = orderService.findOne("1523435920972951344");
        pushMessageService.orderStatus(orderDTO);
    }
}