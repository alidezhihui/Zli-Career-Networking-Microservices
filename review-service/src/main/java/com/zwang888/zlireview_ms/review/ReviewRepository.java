package com.zwang888.zlireview_ms.review;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    // telling Spring Data JPA to find all reviews
    // SELECT * FROM review WHERE company_id = ?;
    List<Review> findByCompanyId(Long companyId);
}
