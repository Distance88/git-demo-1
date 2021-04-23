package com.zhang.controller;

import com.alibaba.fastjson.JSON;
import com.zhang.pojo.Info;
import com.zhang.service.BlogService;
import com.zhang.service.MessageService;
import com.zhang.service.impl.InfoServiceImpl;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (Info)表控制层
 *
 * @author Distance
 * @since 2020-10-15 20:32:07
 */
@RestController
@RequestMapping("info")
public class InfoController {
    /**
     * 服务对象
     */
    @Resource
    private InfoServiceImpl infoService;

    @Resource
    private MessageService messageService;

    @Resource
    private BlogService blogService;

    @RequestMapping("getInfo")
    public JSONObject getInfo(Integer pageNumber) throws IOException {
        JSONObject object = new JSONObject();
        List<Info> infoList = infoService.findAllInfo(pageNumber);
        object.put("code",200);
        object.put("msg","获取成功!");
        object.put("infoList",infoList);
        object.put("total",infoService.getLength());
        return object;
    }

    @RequestMapping("getInfoById")
    public JSONObject getInfoById(Integer id){
        JSONObject object = new JSONObject();
        Info info = infoService.findInfoById(id);
        object.put("code",200);
        object.put("msg","获取成功!");
        object.put("info",info);
        return object;
    }

    @RequestMapping("getInfoListByCondition")
    public JSONObject getInfoListByCondition(Info info,String starTime,String endTime,Integer pageNumber){
        JSONObject object = new JSONObject();
        List<Info> infoList = infoService.findInfoByCondition(info, starTime, endTime,pageNumber);
        object.put("code",200);
        object.put("msg","获取成功!");
        object.put("infoList",infoList);
        return object;
    }

    @RequestMapping("addInfo")
    public JSONObject addInfo(Info info){
        JSONObject object = new JSONObject();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String createtime = format.format(new Date());
        info.setCreatetime(createtime);
        System.out.println(info.getContent());
        infoService.insertInfo(info);
        object.put("code",200);
        object.put("msg","添加成功!");
        return object;
    }

    @RequestMapping("deleteInfo")
    public JSONObject deleteInfo(Integer id) throws IOException {
        JSONObject object = new JSONObject();
        infoService.removeInfoById(id);
        List<Info> infoList = infoService.findAllInfo(1);
        object.put("code",200);
        object.put("msg","删除成功!");
        object.put("infoList",infoList);
        object.put("total",infoService.getLength());
        return object;
    }

    @RequestMapping("batchDeleteInfo")
    public JSONObject batchDelete(String ids) throws IOException {
        JSONObject object = new JSONObject();
        String[] split = ids.split(",");
        Integer idList[] = new Integer[split.length];
        int i = 0;
        for(String id:split){
            idList[i] = Integer.valueOf(id);
            i++;
        }
        infoService.batchRemoveInfoByIds(idList);
        List<Info> infoList = infoService.findAllInfo(1);
        object.put("code",200);
        object.put("msg","删除成功!");
        object.put("infoList",infoList);
        object.put("total",infoService.getLength());
        return object;
    }

    @RequestMapping("getRecentInfo")
    public JSONObject getRecentInfo(){
        JSONObject object = new JSONObject();

        object.put("code",200);
        object.put("recentInfo",infoService.findRecentInfo());
        object.put("recentMessage",messageService.findRecentMessage());
        object.put("recentBlog",blogService.findRecentBlog());
        return object;
    }
}