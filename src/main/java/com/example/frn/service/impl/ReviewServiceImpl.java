package com.example.frn.service.impl;

import com.example.frn.dao.FilmMapper;
import com.example.frn.dao.LikeMapper;
import com.example.frn.dao.ReviewMapper;
import com.example.frn.dao.UserMapper;
import com.example.frn.dto.ReviewPageDTO;
import com.example.frn.entity.Review;
import com.example.frn.service.ReviewService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewMapper reviewMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private FilmMapper filmMapper;
    @Override
    public boolean save(Review review) {
        // 保留一个修改的位置
        review.setStatus(0);
        return reviewMapper.insert(review) > 0;
    }

    @Override
    public boolean updateStatus(Integer id, Integer status) {
        return reviewMapper.updateStatus(id, status) > 0;
    }

    @Override
    public boolean remove(Integer id) {
        return reviewMapper.delete(id) > 0;
    }

    @Autowired
    private LikeMapper likeMapper;
    @Override
    @Transactional
    public boolean updateLikeNum(Integer uid, Integer rid) {
        if (likeMapper.count(uid, rid) == 0) {
            likeMapper.insert(uid, rid);
            return reviewMapper.updateLikeNum(rid, 1) > 0;
        } else {
            likeMapper.delete(uid, rid);
            return reviewMapper.updateLikeNum(rid, -1) > 0;
        }
    }

    @Override
    public Review getById(Integer id) {
        //阅读次数+1后再查看
        reviewMapper.updateViewTimes(id);
        Review review = reviewMapper.selectById(id);
        /*if (review!=null){
            // 根据用户ID查询评论人信息
            review.setUser(userMapper.selectById(review.getUserId()));
            // 根据电影ID查询电影信息
            review.setFilm(filmMapper.selectById(review.getFilmId()));
        }*/
        return review;
    }

    @Override
    public PageInfo<Review> page(ReviewPageDTO dto) {
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        // 根据多个条件查询评论列表
        List<Review> reviewList = reviewMapper.selectList(dto.getFilmId(), dto.getUserId(), dto.getStatus());
        /* // for (Review review : reviewList) {
            // 根据用户ID查询评论人信息
            review.setUser(userMapper.selectById(review.getUserId()));
            // 查询这条评论下的回复
            PageHelper.startPage(1, 5);
            review.setReplyList(reviewMapper.selectListByReviewId(review.getId()));
        }*/
        return new PageInfo<>(reviewList);
    }

    @Override
    public boolean thumpsUp(int userId, int reviewId) {
        if (reviewMapper.countLikeTable(userId,reviewId)>0){
            reviewMapper.updateLikeNum(reviewId,-1);//点赞次数-1
            reviewMapper.deleteLikeTable(userId,reviewId);//删除点赞记录
        }else {
            reviewMapper.updateLikeNum(reviewId,+1);
            reviewMapper.insertLikeTable(userId,reviewId);
        }
        return true;
    }
}
