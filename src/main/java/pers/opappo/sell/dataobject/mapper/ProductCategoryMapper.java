package pers.opappo.sell.dataobject.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import pers.opappo.sell.dataobject.ProductCategory;

import java.util.List;
import java.util.Map;

/**
 * 使用Mybatis对类目表进行增删改查
 */
@Component(value = "ProductCategoryMapper")
public interface ProductCategoryMapper {

    //通过map方式写入，从map中取值插入表中
    @Insert("insert into product_category(category_name, category_type) values (#{category_name, jdbcType=VARCHAR}, #{category_type, jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    //通过对象方式写入
    @Insert("insert into product_category(category_name, category_type) values (#{categoryName, jdbcType=VARCHAR}, #{categoryType, jdbcType=INTEGER})")
    int insertByObject(ProductCategory productCategory);

    //通过type查(type唯一，所以查的是单条记录)
    @Select("select * from product_category where category_type = #{categoryType}")
    @Results({
            @Result(column = "category_id", property = "categoryId"),
            @Result(column = "category_name", property = "categoryName"),
            @Result(column = "category_type", property = "categoryType")
    })
    ProductCategory findByCategoryType(Integer categoryType);

    //通过name查，结果可能不唯一
    @Select("select * from product_category where category_name = #{categoryName}")
    @Results({
            @Result(column = "category_id", property = "categoryId"),
            @Result(column = "category_name", property = "categoryName"),
            @Result(column = "category_type", property = "categoryType")
    })
    List<ProductCategory> findByCategoryName(String categoryName);

    //根据字段更新
    @Update("update product_category set category_name = #{categoryName} where category_type = #{categoryType}")
    int updateByCategoryType(@Param("categoryName") String categoryName,
                             @Param("categoryType") Integer categoryType);

    //根据对象更新
    @Update("update product_category set category_name = #{categoryName} where category_type = #{categoryType}")
    int UpdateByObject(ProductCategory productCategory);

    //删除
    @Delete("delete from product_category where category_type = #{categoryType}")
    int deleteByCategoryType(Integer categoryType);

    //使用xml方式
    ProductCategory selectByCategoryType(Integer categoryType);
}
