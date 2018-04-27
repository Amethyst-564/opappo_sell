package pers.opappo.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 卖家信息实体
 * Created by Luvoratorrrrry on 2018/4/23.
 */
@Data
@Entity
public class SellerInfo {

    @Id
    private String sellerId;

    private String username;

    private String password;

    private String openid;

    //private Date createTime;
    //
    //private Date updateTime;
}
