package com.nagarro.productCommunitySystem.service;

import com.nagarro.productCommunitySystem.model.Product;

import java.util.List;

public interface ProductService {

    Product addProduct(Product product) throws Exception;
    int getProductsCount() throws Exception;

    List<Product> getProducts() throws Exception;

    void updateProduct(Product product) throws Exception;

    List<Product> getProductsBySearchString(String searchString) throws Exception;

    Product getProductByReviewId(long reviewId) throws Exception;
}
