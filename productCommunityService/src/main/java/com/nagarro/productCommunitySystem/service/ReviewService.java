package com.nagarro.productCommunitySystem.service;

import com.nagarro.productCommunitySystem.model.Product;
import com.nagarro.productCommunitySystem.model.Review;

import java.util.List;

public interface ReviewService {

    void addReview(long productId, Review review) throws Exception;

    void approveReview(long reviewId) throws Exception;

    void unApproveReview(long reviewId) throws Exception;
    Review requestReview(Product product) throws Exception;
    int getReviewsCount() throws Exception;

    List<Review> getReviews() throws Exception;
}
