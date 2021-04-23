package com.zhang.controller;

import com.zhang.pojo.Problem;
import com.zhang.service.ProblemService;
import com.zhang.service.impl.ProblemServiceImpl;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Problem)表控制层
 *
 * @author Distance
 * @since 2020-10-15 20:40:06
 */
@RestController
@RequestMapping("problem")
public class ProblemController {
    /**
     * 服务对象
     */
    @Resource
    private ProblemServiceImpl problemService;

    @RequestMapping("getProblem")
    public JSONObject getProblem(Integer pageNumber){
        JSONObject object = new JSONObject();

        List<Problem> problemList = problemService.findAllProblem(pageNumber);
        object.put("code",200);
        object.put("problemList",problemList);
        object.put("total",problemService.getLength());
        return object;
    }
}