package com.example.frn.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Review {
    private Integer id;
    private String content;
    private Integer userId;
    private Integer filmId;
    private Integer reviewId;
    private Integer status;
    private Integer likeNum;
    private Integer viewTimes;
    private Integer isDelete;
    private LocalDateTime created;
    private LocalDateTime updated;
    // 评论人的用户信息
    private User user;
    // 电影信息
    private Film film;
    // 这条评论下的回复
    private List<Review> replyList;
}