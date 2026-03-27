package com.example.frn.service;

import com.example.frn.dto.ReviewPageDTO;
import com.example.frn.entity.Review;
import com.github.pagehelper.PageInfo;

public interface ReviewService {
    boolean save(Review review);
    boolean updateStatus(Integer id, Integer status);

    boolean remove(Integer id);
    boolean updateLikeNum(Integer id, Integer num);

    Review getById(Integer id);

    PageInfo<Review> page(ReviewPageDTO dto);

    boolean thumpsUp(int userId,int reviewId);
}
