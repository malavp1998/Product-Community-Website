package com.nagarro.productCommunitySystem.repository;

import com.nagarro.productCommunitySystem.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
