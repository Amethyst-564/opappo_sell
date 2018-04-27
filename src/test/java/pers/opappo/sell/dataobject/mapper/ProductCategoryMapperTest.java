package pers.opappo.sell.dataobject.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.opappo.sell.dataobject.ProductCategory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper mapper;


    @Test
    public void insertByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("category_name", "冷饮甜品");
        map.put("category_type", 101);
        int result = mapper.insertByMap(map);
        Assert.assertEquals(1, result);

    }

    @Test
    public void insertByObject() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("果蔬生鲜");
        productCategory.setCategoryType(102);
        int result = mapper.insertByObject(productCategory);
        Assert.assertEquals(1, result);
    }

    @Test
    public void findByCategoryType() {
        ProductCategory result = mapper.findByCategoryType(102);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByCategoryName() {
        List<ProductCategory> result = mapper.findByCategoryName("果蔬生鲜");
        Assert.assertNotEquals(0, result.size());
    }

    @Test
    public void updateByCategoryType() {
        int result = mapper.updateByCategoryType("生猛海鲜",102);
        Assert.assertEquals(1, result);
    }

    @Test
    public void updateByObject() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryType(102);
        productCategory.setCategoryName("水果生鲜");
        int result = mapper.UpdateByObject(productCategory);
        Assert.assertEquals(1, result);
    }

    @Test
    public void deleteByCategoryType() {
        int result = mapper.deleteByCategoryType(102);
        Assert.assertEquals(1, result);
    }

    @Test
    public void selectByCategoryType() {
        ProductCategory result = mapper.selectByCategoryType(101);
        Assert.assertNotNull(result);
    }
}