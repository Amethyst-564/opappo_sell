package pers.opappo.sell.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.opappo.sell.dataobject.ProductInfo;
import pers.opappo.sell.enums.ProductStatusEnum;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() {
        ProductInfo productInfo = productService.findOne("564");
        Assert.assertEquals("564", productInfo.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertNotEquals(0, productInfoList.size());
    }

    @Test
    public void findAll() {
        //PageRequest继承自AbstractPageRequest，AbstractPageRequest实现了Pageable接口
        PageRequest request = new PageRequest(0, 2);
        Page<ProductInfo> productInfoPage = productService.findAll(request);
        //System.out.println(productInfoPage.getTotalElements());
        Assert.assertNotEquals(0,productInfoPage.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("565");
        productInfo.setProductName("猪脑");
        productInfo.setProductPrice(new BigDecimal(2.4));
        productInfo.setProductStock(800);
        productInfo.setProductDescription("小补，不咋好吃");
        productInfo.setProductIcon("http://oklij0lk2.bkt.clouddn.com/18-4-6/25254382.jpg");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(2);

        ProductInfo result = productService.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void onSale() {
        ProductInfo result = productService.onSale("568");
        Assert.assertEquals(ProductStatusEnum.UP, result.getProductStatusEnum());
    }

    @Test
    public void offSale() {
        ProductInfo result = productService.offSale("568");
        Assert.assertEquals(ProductStatusEnum.DOWN, result.getProductStatusEnum());
    }
}