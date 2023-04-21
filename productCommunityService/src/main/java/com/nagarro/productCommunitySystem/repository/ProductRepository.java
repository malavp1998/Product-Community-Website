package com.nagarro.productCommunitySystem.repository;

import com.nagarro.productCommunitySystem.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

  @Query("select u FROM Product u where u.name like %?1% or u.brand like %?1% or u.code like %?1%")
  List<Product> findBySearchString(@Param("searchString") String searchString);


 }


