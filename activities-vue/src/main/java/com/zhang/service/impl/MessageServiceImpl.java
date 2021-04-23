package com.zhang.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhang.mapper.MessageMapper;
import com.zhang.pojo.Message;
import com.zhang.service.MessageService;
import com.zhang.utils.RedisUtil;
import com.zhang.utils.TimeUtils;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * (Message)表服务接口
 *
 * @author Distance
 * @since 2020-10-20 10:39:17
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Resource
    private MessageMapper messageMapper;


    @Resource
    private TimeUtils timeUtils;

    @Resource
    private RedisUtil redisUtil;

    @Override
    public List<Message> findAllMessage() {

        List<Message> messageList = new LinkedList<>();
        List<Message> messages = messageMapper.selAllMessage();
        for(Message message:messages){
            message.setChilds(messageMapper.selChildMessage(message.getId()));
            messageList.add(message);
        }
        return messageList;
    }

    @Override
    public void addMessage(Message message) {
        message.setMedate(timeUtils.getCreateTime());
        messageMapper.insertMessage(message);
    }

    @Override
    public List<Message> findRecentMessage() {
        String key = "recentMessage";
        boolean hasKey = redisUtil.hasKey(key);
        if(hasKey){
            List<Object> objects = redisUtil.lGet(key, 0, -1);
            return new ObjectMapper().convertValue(JSONArray.fromObject(objects), new TypeReference<List<Message>>() {});
        }
        List<Message> messageList = messageMapper.selRecentMessage();
        redisUtil.lSet(key,JSONArray.fromObject(messageList),24);
        return messageList;
    }
}