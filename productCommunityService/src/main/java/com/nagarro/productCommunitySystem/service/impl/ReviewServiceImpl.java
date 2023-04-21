package com.nagarro.productCommunitySystem.service.impl;

import com.nagarro.productCommunitySystem.model.Product;
import com.nagarro.productCommunitySystem.model.Review;
import com.nagarro.productCommunitySystem.repository.ProductRepository;
import com.nagarro.productCommunitySystem.repository.ReviewRepository;
import com.nagarro.productCommunitySystem.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ProductServiceImpl productService;

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
    public void unApproveReview(long reviewId) throws Exception {
        try {
            Review existingReview = reviewRepository.findById(reviewId).get();


            if (existingReview != null) {
                existingReview.setReviewApproved(false);
                reviewRepository.save(existingReview);
            }
        } catch (Exception e) {
            throw e;
        }
    }


    @Override
    public Review requestReview(Product product) throws Exception {
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

    @Override
    public List<Review> getReviews() throws Exception {
         try {
             List<Review> reviewList = reviewRepository.findAll();
           for (int i = 0; i < reviewList.size(); i++) {
             Product p = productService.getProductByReviewId(reviewList.get(i).getReviewId());
               Product p1 = new Product();
               p1.setProductId(p.getProductId());
               p1.setName(p.getName());
               p1.setCode(p.getCode());
               p1.setBrand(p.getBrand());
               p1.setPrice(p.getPrice());
               p1.setProductReviews(new ArrayList<>());
               reviewList.get(i).setProduct(p1);
           }
             return reviewList;
         }
         catch (Exception e)
         {
             throw e;
         }
    }
}
