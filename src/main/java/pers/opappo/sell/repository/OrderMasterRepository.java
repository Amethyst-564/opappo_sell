package pers.opappo.sell.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pers.opappo.sell.dataobject.OrderMaster;

/**
 * 订单主表DAO
 * Created by Luvoratorrrrry on 2018/4/8.
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

    //按照买家Openid来查询，防止订单量过大，用分页方式
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
