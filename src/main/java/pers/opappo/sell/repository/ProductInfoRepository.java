package pers.opappo.sell.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.opappo.sell.dataobject.ProductInfo;

import java.util.List;

/**
 * 商品表DAO
 * DAO是接口，要继承JpaRepository
 * Created by Luvoratorrrrry on 2018/4/6.
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);
}
