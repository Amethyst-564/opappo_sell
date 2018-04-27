package pers.opappo.sell.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pers.opappo.sell.dataobject.ProductInfo;
import pers.opappo.sell.dto.CartDTO;

import java.util.List;

public interface ProductService {

    ProductInfo findOne(String productId);

    //查询所有状态为0的商品（面向买家端
    List<ProductInfo> findUpAll();

    //查询所有商品（面向卖家端
    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);

    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);

    //上架
    ProductInfo onSale(String productId);

    //下架
    ProductInfo offSale(String productId);

}
