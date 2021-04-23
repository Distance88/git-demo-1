package com.zhang.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhang.mapper.AnswerMapper;
import com.zhang.mapper.InfoMapper;
import com.zhang.mapper.ProblemMapper;
import com.zhang.pojo.Answer;
import com.zhang.pojo.ProAnswer;
import com.zhang.pojo.Problem;
import com.zhang.service.AnswerService;
import com.zhang.utils.RedisUtil;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * (Answer)表服务接口
 *
 * @author Distance
 * @since 2020-10-23 18:11:16
 */
@Service
public class AnswerServiceImpl implements AnswerService {

    @Resource
    private AnswerMapper answerMapper;


    @Resource
    private RedisUtil redisUtil;


    @Override
    public List<ProAnswer> findAllProAnswer(Integer pageNumber) {
        String Key = "problemList";
        Integer start = (pageNumber - 1) * 5;
        Integer end = start + 4;
        boolean hasKey = redisUtil.hasKey(Key);
        ObjectMapper objectMapper = new ObjectMapper();
        List<ProAnswer> proAnswerList = new LinkedList<>();
        if(hasKey){
            List<Problem> problemList = objectMapper.convertValue(JSONArray.fromObject(redisUtil.lGet(Key, start, end)), new TypeReference<List<Problem>>() {});
            for(Problem problem:problemList){
                ProAnswer proAnswer = new ProAnswer(problem.getId(),problem.getTitle());
                String key ="answer_problem_pid_"+problem.getId();
                boolean hasKey1 = redisUtil.hasKey(key);
                if(hasKey1){
                    proAnswer.setAnswerList(objectMapper.convertValue(JSONArray.fromObject(redisUtil.lGet(key, 0, -1)), new TypeReference<List<Answer>>() {}));
                }
                proAnswerList.add(proAnswer);
            }
        }
        return proAnswerList;
    }

    @Override
    public void addAnswer(Answer answer) {
        String key = "answer_problem_pid_"+answer.getPid();
        boolean hasKey = redisUtil.hasKey(key);
        answerMapper.insertAnswer(answer);
        if(hasKey){
            redisUtil.lSet(key,JSONArray.fromObject(answer),24);
        }else{
            List<Answer> answerList = new LinkedList<>();
            answerList.add(answer);
            redisUtil.lSet(key,JSONArray.fromObject(answerList),24);
        }

    }
}