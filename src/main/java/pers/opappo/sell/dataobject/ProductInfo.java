package pers.opappo.sell.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import pers.opappo.sell.enums.ProductStatusEnum;
import pers.opappo.sell.utils.EnumUtil;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品实体
 * Created by Luvoratorrrrry on 2018/4/6.
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo implements Serializable {

    private static final long serialVersionUID = 7649866568436865016L;

    @Id
    private String productId;

    //商品名
    private String productName;

    //单价 mysql的decimal在Java里用BigDecimal
    private BigDecimal productPrice;

    //库存
    private Integer productStock;

    //描述
    private String productDescription;

    //缩略图
    private String productIcon;

    //状态 0正常1下架 默认正常
    private Integer productStatus = ProductStatusEnum.UP.getCode();

    //类目编号
    private Integer categoryType;

    //创建时间
    private Date createTime;

    //修改时间
    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum() {
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }

}
