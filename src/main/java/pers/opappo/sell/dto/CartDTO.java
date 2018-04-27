package pers.opappo.sell.dto;

import lombok.Data;

/**
 * 购物车DTO
 * Created by Luvoratorrrrry on 2018/4/9.
 */
@Data
public class CartDTO {

    //商品id
    private String productId;

    //商品数量
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
