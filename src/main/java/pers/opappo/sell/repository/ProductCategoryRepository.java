package pers.opappo.sell.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.opappo.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * 商品类目DAO
 * Created by Luvoratorrrrry on 2018/4/3.
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
