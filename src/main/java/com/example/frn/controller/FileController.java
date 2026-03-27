package com.example.frn.controller;

import com.example.frn.util.MinioUtil;
import com.example.frn.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 提供了文件上传(预览、下载、删除)
 */
@RestController
@RequestMapping("api/v1/file")
public class FileController {
    @Autowired
    private MinioUtil minioUtil;
    @PostMapping("upload")
    public R upload( MultipartFile multipartFile){
        String objNmae = minioUtil.upload(multipartFile);
        return R.ok(objNmae);
    }

}
