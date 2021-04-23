package com.zhang.controller;

import com.zhang.pojo.Message;
import com.zhang.service.MessageService;
import com.zhang.service.impl.MessageServiceImpl;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (Message)表控制层
 *
 * @author Distance
 * @since 2020-10-20 10:39:17
 */
@RestController
@RequestMapping("message")
public class MessageController {
    /**
     * 服务对象
     */
    @Resource
    private MessageServiceImpl messageService;

    @RequestMapping("getMessageList")
    public JSONObject getMessageList(){

        JSONObject object = new JSONObject();
        List<Message> messageList = messageService.findAllMessage();
        object.put("code",200);
        object.put("messageList",messageList);
        object.put("msg","获取留言成功!");
        object.put("length",messageList.size());
        return object;
    }

    @RequestMapping("addMessage")
    public JSONObject addMessage(Message message){
        JSONObject object = new JSONObject();
        messageService.addMessage(message);
        object.put("code",200);
        object.put("msg","留言成功!");
        return object;
    }


}