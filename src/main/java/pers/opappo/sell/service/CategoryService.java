package pers.opappo.sell.service;

import pers.opappo.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目Service接口
 * Created by Luvoratorrrrry on 2018/4/5.
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    //卖家端后台管理会用到的查询所有类目
    List<ProductCategory> findAll();

    //买家端使用的按类型查询
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
