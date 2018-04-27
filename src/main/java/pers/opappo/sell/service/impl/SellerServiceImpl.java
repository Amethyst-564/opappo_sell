package pers.opappo.sell.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.opappo.sell.dataobject.SellerInfo;
import pers.opappo.sell.repository.SellerInfoRepository;
import pers.opappo.sell.service.SellerService;

/**
 * Created by Luvoratorrrrry on 2018/4/23.
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}
