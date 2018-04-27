package pers.opappo.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 项目中用到的url
 * Created by Luvoratorrrrry on 2018/4/23.
 */
@Data
@ConfigurationProperties(prefix = "projecturl")
@Component
public class ProjectUrlConfig {

    //微信公众平台授权url
    public String wechatMpAuthorize;

    //微信开放平台授权url
    public String wechatOpenAuthorize;

    //项目url
    public String sell;


}
