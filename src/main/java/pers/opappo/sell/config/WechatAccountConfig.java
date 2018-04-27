package pers.opappo.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 账号相关配置
 * Created by Luvoratorrrrry on 2018/4/12.
 */
@Component
@Data
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    /*公众平台id和密钥*/
    private String mpAppId;

    private String mpAppSecret;

    /*开放平台id和密钥*/
    private String openAppId;

    private String openAppSecret;

    /*商户号*/
    private String mchId;

    /*商户密钥*/
    private String mchKey;

    /*商户证书路径*/
    private String keyPath;

    /*微信支付异步通知地址*/
    private String notifyUrl;

    /*微信模板id*/
    private Map<String, String> templateId;
}
