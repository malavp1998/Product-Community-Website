package com.nagarro.productCommunitySystem.repository;

import com.nagarro.productCommunitySystem.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
