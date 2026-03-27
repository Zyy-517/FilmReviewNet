package com.example.frn.controller;

import cn.hutool.core.bean.BeanUtil;
import com.example.frn.dto.ReviewInsertDTO;
import com.example.frn.dto.ReviewPageDTO;
import com.example.frn.entity.Review;
import com.example.frn.service.ReviewService;
import com.example.frn.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping("thumpsUp/{userId}/{reviewId}")
    public R thumpsUp(@PathVariable Integer userId,@PathVariable Integer reviewId){
        return R.ok(reviewService.thumpsUp(userId,reviewId));
    }

    @PostMapping("save")
    public R save(@RequestBody ReviewInsertDTO dto) {
        Review review = BeanUtil.copyProperties(dto, Review.class);
        if (reviewService.save(review))
            return R.ok(true);
        else
            return R.error(false);
    }

    @PostMapping("updateStatus/{rid}/{status}")
    public R updateStatus(@PathVariable Integer rid, @PathVariable Integer status) {
        if (reviewService.updateStatus(rid, status))
            return R.ok(true);
        else
            return R.error(false);
    }

    @PostMapping("remove/{id}")
    public R remove(@PathVariable Integer id) {
        if (reviewService.remove(id))
            return R.ok(true);
        else
            return R.error(false);
    }

    @PostMapping("like/{uid}/{rid}")
    public R like(@PathVariable Integer uid, @PathVariable Integer rid) {
        if (reviewService.updateLikeNum(uid, rid))
            return R.ok(true);
        else
            return R.error(false);
    }

    @GetMapping("detail/{id}")
    public R detail(@PathVariable Integer id) {
        return R.ok(reviewService.getById(id));
    }

    @PostMapping("page")
    public R page(@RequestBody ReviewPageDTO dto) {
        return R.ok(reviewService.page(dto));
    }

}
