package com.zhang.service;

import com.zhang.pojo.Problem;

import java.util.List;

/**
 * (Problem)表服务接口
 *
 * @author Distance
 * @since 2020-10-15 20:40:06
 */
public interface ProblemService {

    List<Problem> findAllProblem(Integer pageNumber);

    int getLength();
}