package com.zhang.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created with IntelliJ IDEA.
 * Author: Distance
 * Date: 2020/11/16/15:01
 */

public interface OssService {

    String uploadFile(MultipartFile multipartFile);

    void deleteFile(String fineName);


}
