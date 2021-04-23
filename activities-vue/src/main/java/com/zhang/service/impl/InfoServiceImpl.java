package com.zhang.service.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhang.mapper.InfoMapper;
import com.zhang.pojo.Info;
import com.zhang.service.InfoService;
import com.zhang.utils.RedisUtil;
import net.sf.json.JSONArray;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

/**
 * (Info)表服务接口
 *
 * @author Distance
 * @since 2020-10-15 20:32:07
 */
@Service
public class InfoServiceImpl implements InfoService {


    @Resource
    private InfoMapper infoMapper;

    @Resource
    private RedisUtil redisUtil;

    @Override
    public List<Info> findAllInfo(Integer pageNumber) throws IOException {
        String key = "infoList";
        Integer start = (pageNumber - 1) * 5;
        Integer end = start + 4;

        boolean hasKey = redisUtil.hasKey(key);
        if(hasKey){
            List<Object> infoList = redisUtil.lGet(key,start,end);
            return new ObjectMapper().convertValue(JSONArray.fromObject(infoList), new TypeReference<List<Info>>() {});
        }
        List<Info> infoAllList = infoMapper.selAllInfo();
        List<Info> res = new LinkedList<>();
        for(int i=start;i<=(end >= infoAllList.size() ? infoAllList.size() - 1 : end)  ;i++){
            res.add(infoAllList.get(i));
        }
        redisUtil.lSet(key,JSONArray.fromObject(infoAllList),24);
        return res;
    }
    @Override
    public Info findInfoById(Integer id) {

        String key = "info_"+id;
        boolean hasKey = redisUtil.hasKey(key);
        if(hasKey){
            Object info = redisUtil.get(key);
            return new ObjectMapper().convertValue(info,Info.class);
        }else{
            Info info = infoMapper.selInfoById(id);
            redisUtil.set(key,info);
            return info;
        }
    }

    @Override
    public void insertInfo(Info info) {
        String key = "infoList";
        boolean hasKey = redisUtil.hasKey(key);
        infoMapper.addInfo(info);
        if(hasKey){
            redisUtil.lSet(key,info,24);
        }
    }

    @Override
    public List<Info> findInfoByCondition(Info info, String starTime, String endTime,Integer pageNumber) {
        return infoMapper.selInfoByCondition(info,starTime,endTime,(pageNumber - 1) * 5);
    }

    @Override
    public void removeInfoById(Integer id) {
        String key = "infoList";
        boolean hasKey = redisUtil.hasKey(key);
        if(hasKey){
            Info info = infoMapper.selInfoById(id);
            redisUtil.lRemove(key,1,JSONArray.fromObject(info).get(0));
        }
        infoMapper.delInfoById(id);
    }

    @Override
    public void batchRemoveInfoByIds(Integer ids[]) {
        for(Integer id:ids){
            removeInfoById(id);
        }
    }

    @Override
    public int getLength() {
        return infoMapper.selInfoLength();
    }

    @Override
    public List<Info> findRecentInfo() {
        String key = "recentInfo";
        boolean hasKey = redisUtil.hasKey(key);
        if(hasKey){
            List<Object> objects = redisUtil.lGet(key, 0, -1);
            return new ObjectMapper().convertValue(JSONArray.fromObject(objects), new TypeReference<List<Info>>() {});
        }
        List<Info> infoList = infoMapper.selRecentInfo();
        redisUtil.lSet(key,JSONArray.fromObject(infoList),24);
        return infoList;
    }
}