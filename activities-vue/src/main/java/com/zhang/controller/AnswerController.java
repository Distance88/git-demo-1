package com.zhang.controller;

import com.zhang.pojo.Answer;
import com.zhang.pojo.ProAnswer;
import com.zhang.service.AnswerService;
import com.zhang.service.ProblemService;
import com.zhang.service.impl.AnswerServiceImpl;
import com.zhang.utils.CommonmarkUtil;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (Answer)表控制层
 *
 * @author Distance
 * @since 2020-10-23 18:11:16
 */
@RestController
@RequestMapping("answer")
public class AnswerController {
    /**
     * 服务对象
     */
    @Resource
    private AnswerServiceImpl answerService;

    @Resource
    private ProblemService problemService;
    @RequestMapping("findProAnswer")
    public JSONObject findProAnswer(Integer pageNumber){
        JSONObject object = new JSONObject();
        List<ProAnswer> proAnswerList = answerService.findAllProAnswer(pageNumber);
        object.put("code",200);
        object.put("msg","获取成功!");
        object.put("proAnswerList",proAnswerList);
        object.put("total",problemService.getLength());
        return object;
    }

    @RequestMapping("addAnswer")
    public JSONObject addAnswer(Answer answer){
        JSONObject object = new JSONObject();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time = format.format(new Date());
        answer.setTime(time);
        CommonmarkUtil util = new CommonmarkUtil();
        answer.setAnswer(util.transferMarkDownToHtml(answer.getAnswer()));
        answerService.addAnswer(answer);
        object.put("code",200);
        object.put("msg","添加成功!");
        return object;
    }
}