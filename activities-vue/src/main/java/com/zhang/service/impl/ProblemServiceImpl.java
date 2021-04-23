package com.zhang.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhang.mapper.AnswerMapper;
import com.zhang.mapper.ProblemMapper;
import com.zhang.pojo.Answer;
import com.zhang.pojo.Problem;
import com.zhang.service.ProblemService;
import com.zhang.utils.RedisUtil;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * (Problem)表服务接口
 *
 * @author Distance
 * @since 2020-10-15 20:40:06
 */
@Service
public class ProblemServiceImpl implements ProblemService {

    @Resource
    private ProblemMapper problemMapper;

    @Resource
    private AnswerMapper answerMapper;

    @Resource
    private RedisUtil redisUtil;
    @Override
    public List<Problem> findAllProblem(Integer pageNumber) {

        String key = "problemList";
        Integer start = (pageNumber - 1) * 5;
        Integer end = start + 4;

        boolean hasKey = redisUtil.hasKey(key);
        if(hasKey){
            List<Object> problemList = redisUtil.lGet(key, start,end);
            return new ObjectMapper().convertValue(JSONArray.fromObject(problemList), new TypeReference<List<Problem>>() {});
        }else {
            List<Problem> problemList = new LinkedList<>();
            List<Problem> problems = problemMapper.selAllProblem();
            for(Problem problem:problems){
                List<Answer> answerList = answerMapper.selAnswerByPid(problem.getId());
                problem.setAnswerList(answerList);
                problemList.add(problem);
            }
            List<Problem> res = new LinkedList<>();
            for(int i=start;i<=(end >= problemList.size() ? problemList.size() - 1 : end)  ;i++){
                res.add(problemList.get(i));
            }
            redisUtil.lSet(key,JSONArray.fromObject(problemList),24);
            return res;
        }
    }
    @Override
    public int getLength() {
        return problemMapper.selCount();
    }
}