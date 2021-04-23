package com.zhang.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CannedAccessControlList;
import com.zhang.service.OssService;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * Author: Distance
 * Date: 2020/11/16/15:02
 */
@Service
public class OssServiceImpl implements OssService {

    private String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";

    private String accessKeyId = "LTAI4G9mTsbTkpMhcjHbSeaF";

    private String accessKeySecret = "WGA0yVmPO36uqLxTICbg1CcvJVwmL9";

    private String bucketName = "ngyst";



    @Override
    public String uploadFile(MultipartFile multipartFile) {

        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        InputStream inputStream = null;

        try {
            inputStream = multipartFile.getInputStream();

        } catch (IOException e) {

            e.printStackTrace();
        }

        String datePath = new DateTime().toString("yyyy/MM/dd");

        String filename =datePath +"/" + UUID.randomUUID().toString().replaceAll("-","") + multipartFile.getOriginalFilename();

        ossClient.setBucketAcl(bucketName,CannedAccessControlList.PublicRead);

        ossClient.putObject(bucketName, filename, inputStream);

        ossClient.shutdown();

        StringBuffer webUrl = new StringBuffer();
        webUrl.append("http://ngyst.oss-cn-hangzhou.aliyuncs.com/")
                .append(filename);

        return webUrl.toString();
    }

    @Override
    public void deleteFile(String filename) {
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        ossClient.deleteObject(bucketName,filename.substring(42));

        ossClient.shutdown();
    }
}
