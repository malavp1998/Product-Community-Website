package com.nagarro.productCommunitySystem.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reviewId;
    private int rating;
    private String review;
    //@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @ManyToOne()
    private Product product;
    private boolean isReviewApproved;
}
