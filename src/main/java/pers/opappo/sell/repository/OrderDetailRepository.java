package pers.opappo.sell.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.opappo.sell.dataobject.OrderDetail;

import java.util.List;

/**
 * 订单详情DAO
 * Created by Luvoratorrrrry on 2018/4/8.
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    List<OrderDetail> findByOrderId(String orderId);
}
