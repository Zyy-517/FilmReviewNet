package com.example.frn.util;

import cn.hutool.core.util.StrUtil;
import com.example.frn.config.MinioConfig;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.UUID;

@Component
public class MinioUtil {
    @Autowired
    private MinioConfig minioConfig;
    @Resource
    private MinioClient minioClient;

    /**
     * 上传文件：将用户上传的文件保存到minio当中
     * @param multipartFile 封装上传文件的io信息
     * @return 上传成功后返回文件的minio访问地址 URL
     */
    public String upload(MultipartFile multipartFile){
        String originalFilename = multipartFile.getOriginalFilename();
        //如果原始文件名为"空"
        if (StrUtil.isBlank(originalFilename)){
            throw new RuntimeException("获取文件信息失败");
        }
        //给文件生成一个随机且不会重复的名称：UUID随机名称 + 文件后缀
        String fileName = UUID.randomUUID()
                + originalFilename.substring(originalFilename.lastIndexOf('.'));
        //定义Object Name : 2024-10-20/uuid.后缀
        String objectName = LocalDate.now() + "/" + fileName;
        try {
            //封装要保存的对象信息
            PutObjectArgs args = PutObjectArgs.builder()
                    .bucket(minioConfig.getBucketName())//选择桶
                    .object(objectName)//对象名
                    .stream(multipartFile.getInputStream(),multipartFile.getSize(),-1)
                    .contentType(multipartFile.getContentType())//设置文件类型
                    .build();
            minioClient.putObject(args);//保存文件
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return minioConfig.getEndpoint() + "/" +minioConfig.getBucketName() + "/"+ objectName;
    }
}
