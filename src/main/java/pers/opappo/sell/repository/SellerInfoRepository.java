package pers.opappo.sell.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.opappo.sell.dataobject.SellerInfo;

/**
 * 卖家信息DAO
 * Created by Luvoratorrrrry on 2018/4/23.
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {

    SellerInfo findByOpenid(String openid);
}
