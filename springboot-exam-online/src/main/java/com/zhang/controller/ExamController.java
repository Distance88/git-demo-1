package com.zhang.controller;

import com.zhang.pojo.Exam;
import com.zhang.pojo.Examination;
import com.zhang.service.ExamService;
import com.zhang.service.impl.ExamServiceImpl;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Exam)表控制层
 *
 * @author Distance
 * @since 2021-01-24 18:46:28
 */
@RestController
@RequestMapping("exam")
public class ExamController {
    /**
     * 服务对象
     */
    @Resource
    private ExamServiceImpl examService;


    @RequestMapping("createExam")
    public JSONObject createExam(@Param("exam")Exam exam){
        JSONObject object = new JSONObject();
        Examination examination = examService.createExam(exam);

        object.put("code",200);
        object.put("msg","创建试卷成功!");
        object.put("choiceList",examination.getChoiseList());
        object.put("blankList",examination.getBlankList());
        return object;
    }

}