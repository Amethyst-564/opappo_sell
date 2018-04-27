package pers.opappo.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import pers.opappo.sell.enums.OrderStatusEnum;
import pers.opappo.sell.enums.PayStatusEnum;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单主表实体
 * Created by Luvoratorrrrry on 2018/4/8.
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    //订单Id
    @Id
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
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    //支付状态 默认0未支付
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    //创建时间
    private Date createTime;

    //更新时间
    private Date updateTime;

    //可以这么写但是不推荐，Service和Controller都会用到这个类，写在这里会很乱。推荐单独建立dto对象！
    //@Transient
    //private List<OrderDetail> orderDetailList;
}
