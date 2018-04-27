package pers.opappo.sell.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pers.opappo.sell.dataobject.ProductInfo;
import pers.opappo.sell.dto.CartDTO;
import pers.opappo.sell.enums.ProductStatusEnum;
import pers.opappo.sell.enums.ResultEnum;
import pers.opappo.sell.exception.SellException;
import pers.opappo.sell.repository.ProductInfoRepository;
import pers.opappo.sell.service.ProductService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * 商品Service实现类
 * Created by Luvoratorrrrry on 2018/4/6.
 */
@Service
//@CacheConfig(cacheNames = "product")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    //@Cacheable(key = "123")
    public ProductInfo findOne(String productId) {
        ProductInfo productInfo = new ProductInfo();
        try {
            productInfo = repository.findById(productId).get();
        } catch (NoSuchElementException e) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        //return repository.findById(productId).get();
        return productInfo;
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    //@CachePut(key = "123")
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {

            ProductInfo productInfo = new ProductInfo();
            try {
                productInfo = repository.findById(cartDTO.getProductId()).get();
            } catch (NoSuchElementException e) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            //ProductInfo productInfo = repository.findById(cartDTO.getProductId()).get();
            //if (productInfo == null) {
            //    throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            //}

            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);

            repository.save(productInfo);
        }

    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {

        for (CartDTO cartDTO : cartDTOList) {

            ProductInfo productInfo = new ProductInfo();
            try {
                productInfo = repository.findById(cartDTO.getProductId()).get();
            } catch (NoSuchElementException e) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            //判断一下库存是否充足，如果不足就报错
            if (result < 0) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            //充足就将做差之后的库存数存回数据库
            productInfo.setProductStock(result);

            repository.save(productInfo);

        }
    }

    @Override
    public ProductInfo onSale(String productId) {

        ProductInfo productInfo = new ProductInfo();

        try {
            productInfo = repository.findById(productId).get();
        } catch (NoSuchElementException e) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        //如果是在售中就不能上架了
        if (productInfo.getProductStatusEnum() == ProductStatusEnum.UP) {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        //更新状态
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());

        return repository.save(productInfo);
    }

    @Override
    public ProductInfo offSale(String productId) {

        ProductInfo productInfo = new ProductInfo();

        try {
            productInfo = repository.findById(productId).get();
        } catch (NoSuchElementException e) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        //如果是在售中就不能上架了
        if (productInfo.getProductStatusEnum() == ProductStatusEnum.DOWN) {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        //更新状态
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());

        return repository.save(productInfo);
    }
}
