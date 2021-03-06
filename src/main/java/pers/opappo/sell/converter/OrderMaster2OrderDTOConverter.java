package pers.opappo.sell.converter;

import org.springframework.beans.BeanUtils;
import pers.opappo.sell.dataobject.OrderMaster;
import pers.opappo.sell.dto.OrderDTO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * OrderMaster to OrderDTO 转换器
 * Created by Luvoratorrrrry on 2018/4/9.
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster) {

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList) {
        return orderMasterList.stream().map(e ->
                convert(e)
        ).collect(Collectors.toList());
    }
}
