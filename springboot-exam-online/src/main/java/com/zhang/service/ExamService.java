package com.zhang.service;

import com.zhang.pojo.Exam;
import com.zhang.pojo.Examination;

/**
 * (Exam)表服务接口
 *
 * @author Distance
 * @since 2021-01-24 18:46:28
 */
public interface ExamService {


    Examination createExam(Exam exam);

}