package pers.opappo.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 商品（包括类目）的ViewObject
 * Created by Luvoratorrrrry on 2018/4/6.
 */
@Data
public class ProductVO implements Serializable{

    private static final long serialVersionUID = 4137184396489628450L;

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
