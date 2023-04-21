package com.nagarro.productCommunitySystem.service.impl;

import com.nagarro.productCommunitySystem.model.Product;
import com.nagarro.productCommunitySystem.repository.ProductRepository;
import com.nagarro.productCommunitySystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) throws Exception {
        try {
            product.setBrand(product.getBrand().trim());
            product.setName(product.getName().trim());
            product.setCode(product.getCode().trim());
            return productRepository.save(product);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int getProductsCount() throws Exception {
        try {
            return productRepository.findAll().size();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Product> getProducts() throws Exception {
        try {
            return productRepository.findAll();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void updateProduct(Product product) throws Exception {
        try {
            Product existingProduct = productRepository.findById(product.getProductId()).get();
            if (existingProduct != null) {
                existingProduct.setCode(product.getCode());
                existingProduct.setName(product.getName());
                existingProduct.setBrand(product.getBrand());
                existingProduct.setPrice(product.getPrice());
                existingProduct.getProductReviews().add(product.getProductReviews().get(0));
                productRepository.save(existingProduct);
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
