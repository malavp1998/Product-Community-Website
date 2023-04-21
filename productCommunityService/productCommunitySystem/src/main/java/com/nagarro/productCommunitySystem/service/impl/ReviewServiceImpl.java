package com.nagarro.productCommunitySystem.service.impl;

import com.nagarro.productCommunitySystem.model.Product;
import com.nagarro.productCommunitySystem.model.Review;
import com.nagarro.productCommunitySystem.repository.ProductRepository;
import com.nagarro.productCommunitySystem.repository.ReviewRepository;
import com.nagarro.productCommunitySystem.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public void addReview(long productId, Review review) throws Exception {
        try {
            Product existingProduct = productRepository.findById(productId).get();
            if (existingProduct != null) {
                review.setReviewApproved(false);
                existingProduct.getProductReviews().add(review);
                productRepository.save(existingProduct);

            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void approveReview(long reviewId) throws Exception {
        try {
            Review existingReview = reviewRepository.findById(reviewId).get();
            if (existingReview != null) {
                existingReview.setReviewApproved(true);
                reviewRepository.save(existingReview);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Product requestReview(Review review) throws Exception {
        return null;
    }

    @Override
    public int getReviewsCount() throws Exception {
        try {
            return reviewRepository.findAll().size();
        } catch (Exception e) {
            throw e;
        }
    }
}
