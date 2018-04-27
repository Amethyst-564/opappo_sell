package pers.opappo.sell.service;

/**
 * 秒杀Service接口
 * Created by Luvoratorrrrry on 2018/4/27.
 */
public interface SecKillService {

    String querySecKillProductInfo(String productId);

    void orderProductMockDiffUser(String productId);
}
