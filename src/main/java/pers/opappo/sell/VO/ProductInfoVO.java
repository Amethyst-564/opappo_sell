package pers.opappo.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品详情ViewObject
 * Created by Luvoratorrrrry on 2018/4/6.
 */
@Data
public class ProductInfoVO implements Serializable{

    private static final long serialVersionUID = -1256243577602099715L;

    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;
}
