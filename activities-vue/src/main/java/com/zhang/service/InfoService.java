package com.zhang.service;

import com.zhang.pojo.Info;

import java.io.IOException;
import java.util.List;

/**
 * (Info)表服务接口
 *
 * @author Distance
 * @since 2020-10-15 20:32:06
 */
public interface InfoService {

    List<Info> findAllInfo(Integer pageNumber) throws IOException;

    Info findInfoById(Integer id);

    void insertInfo(Info info);

    List<Info> findInfoByCondition(Info info,String starTime,String endTime,Integer pageNumber);

    void removeInfoById(Integer id);

    void batchRemoveInfoByIds(Integer ids[]);

    int getLength();

    List<Info> findRecentInfo();
}

