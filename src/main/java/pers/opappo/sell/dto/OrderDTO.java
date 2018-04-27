package pers.opappo.sell.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import pers.opappo.sell.dataobject.OrderDetail;
import pers.opappo.sell.enums.OrderStatusEnum;
import pers.opappo.sell.enums.PayStatusEnum;
import pers.opappo.sell.utils.EnumUtil;
import pers.opappo.sell.utils.serializer.Date2LongSerializer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单数据传输对象（DTO）
 * Created by Luvoratorrrrry on 2018/4/8.
 */
@Data
//不显示NULL 旧版
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//不显示NULL 新版
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

    //订单Id
    private String orderId;

    //买家名字
    private String buyerName;

    //买家电话
    private String buyerPhone;

    //买家地址
    private String buyerAddress;

    //买家微信openid
    private String buyerOpenid;

    //订单总金额
    private BigDecimal orderAmount;

    //订单状态 默认0新下单
    private Integer orderStatus;

    //支付状态 默认0未支付
    private Integer payStatus;

    //创建时间
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    //更新时间
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }
}
