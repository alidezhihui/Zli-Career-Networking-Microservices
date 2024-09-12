package com.zwang888.zlireview_ms.review;

import java.util.List;


public interface ReviewService {
    // we don't need dependency on companyId, so remove them all
    List<Review> getAllReviews(Long companyId);
    boolean addReview(Long companyId, Review review);
    Review getReview(Long reviewId);
    boolean updateReview(Long reviewId, Review review);
    boolean deleteReview(Long reviewId);
}
