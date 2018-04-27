package pers.opappo.sell.service;

import pers.opappo.sell.dataobject.SellerInfo;

/**
 * 卖家端Service接口
 */
public interface SellerService {

    /**
     * 通过openid查询卖家信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
