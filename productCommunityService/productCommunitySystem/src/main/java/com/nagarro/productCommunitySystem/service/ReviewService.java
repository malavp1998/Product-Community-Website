package com.nagarro.productCommunitySystem.service;

import com.nagarro.productCommunitySystem.model.Product;
import com.nagarro.productCommunitySystem.model.Review;

public interface ReviewService {

    void addReview(long productId, Review review) throws Exception;

    void approveReview(long reviewId) throws Exception;
    Product requestReview(Review review) throws Exception;
    int getReviewsCount() throws Exception;
}
