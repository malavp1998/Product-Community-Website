package com.nagarro.productCommunitySystem.controller.reviewController;

import com.nagarro.productCommunitySystem.controller.registrationController.RegistrationController;
import com.nagarro.productCommunitySystem.model.Product;
import com.nagarro.productCommunitySystem.model.Review;
import com.nagarro.productCommunitySystem.service.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    private Logger logger = LoggerFactory.getLogger(ReviewController.class);

    @PostMapping("/review/{productId}")
    public void addReview(@PathVariable("productId") long productId, @RequestBody Review review) {
        try {
            reviewService.addReview(productId, review);
        } catch (Exception e) {
            logger.error("Exception in method addReview() " + e);
        }
    }

    @PostMapping("/review/approve/{reviewId}")
    public void approveReview(@PathVariable("reviewId") long reviewId) {
        try {
            reviewService.approveReview(reviewId);
        } catch (Exception e) {
            logger.error("Exception in method approveReview() " + e);
        }
    }

    @GetMapping("/review/count")
    public ResponseEntity<Integer> reviewCount() {
        try {
            return new ResponseEntity<>(reviewService.getReviewsCount(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Exception in method reviewCount() " + e);
        }
        return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);

    }


}
