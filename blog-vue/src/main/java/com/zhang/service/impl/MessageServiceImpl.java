package com.zhang.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhang.mapper.MessageMapper;
import com.zhang.pojo.Message;
import com.zhang.service.MessageService;
import com.zhang.utils.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * (Message)表服务接口
 *
 * @author Distance
 * @since 2020-09-22 20:58:48
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Resource
    private MessageMapper messageMapper;

    @Resource
    private RedisUtil redisUtil;

    ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public List<Message> findAllMessage() {
        String key = "messageList";
        boolean hasKey = redisUtil.hasKey(key);
        if(hasKey){
            Object messageList = redisUtil.get(key);
            return objectMapper.convertValue(messageList, new TypeReference<List<Message>>() {});
        }else {
            List<Message> messageList = new LinkedList<>();
            List<Message> messages= messageMapper.selAllMessage();
            for(Message message : messages){
                List<Message> childMessage = messageMapper.selChildMessage(message.getId());
                message.setChilds(childMessage);
                messageList.add(message);
            }

            redisUtil.set(key,messageList);
            return messageList;
        }

    }

    @Override
    public void addMessage(Message message) {
        messageMapper.insertMessage(message);
    }

}