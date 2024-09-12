package com.zwang888.zlireview_ms.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(@RequestParam Long companyId) {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addReview(@RequestParam Long companyId, @RequestBody Review review) {
        if (reviewService.addReview(companyId, review))
            return new ResponseEntity<>("Successfully added a review", HttpStatus.CREATED);
        return new ResponseEntity<>("Company not Found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long reviewId) {
        return new ResponseEntity<>(reviewService.getReview(reviewId), HttpStatus.OK);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long reviewId, @RequestBody Review review) {
        if (reviewService.updateReview(reviewId, review)) {
            return new ResponseEntity<>("Successfully updated a review", HttpStatus.OK);
        }
        return new ResponseEntity<>("Company not Found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long reviewId) {
        if (reviewService.deleteReview(reviewId)) {
            return new ResponseEntity<>("Successfully deleted a review", HttpStatus.OK);
        }
        return new ResponseEntity<>("Company not Found", HttpStatus.NOT_FOUND);
    }
}
