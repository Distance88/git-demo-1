package com.zhang.service;

import com.zhang.pojo.Message;

import java.util.List;

/**
 * (Message)表服务接口
 *
 * @author Distance
 * @since 2020-09-22 20:58:48
 */
public interface MessageService {

    List<Message> findAllMessage();

    void addMessage(Message message);
}