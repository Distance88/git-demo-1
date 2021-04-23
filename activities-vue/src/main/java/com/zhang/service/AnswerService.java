package com.zhang.service;

import com.zhang.pojo.Answer;
import com.zhang.pojo.ProAnswer;

import java.util.List;

/**
 * (Answer)表服务接口
 *
 * @author Distance
 * @since 2020-10-23 18:11:16
 */
public interface AnswerService {

    List<ProAnswer> findAllProAnswer(Integer pageNumber);

    void addAnswer(Answer answer);
}