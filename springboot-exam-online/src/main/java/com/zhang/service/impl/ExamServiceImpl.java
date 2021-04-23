package com.zhang.service.impl;

import com.zhang.mapper.ExamMapper;
import com.zhang.pojo.Blank;
import com.zhang.pojo.Choise;
import com.zhang.pojo.Examination;
import com.zhang.service.ExamService;

import com.zhang.pojo.Exam;
import com.zhang.service.ExamService;
import com.zhang.utils.TimeUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Exam)表服务接口
 *
 * @author Distance
 * @since 2021-01-24 18:46:28
 */
@Service
public class ExamServiceImpl implements ExamService {


    @Resource
    private ExamMapper examMapper;

    @Override
    public Examination createExam(Exam exam) {

        examMapper.insertExam(exam);
        Examination examination = new Examination();
        List<Choise> choiseList = examMapper.selChoiseByType(exam.getChoiceIds(), exam.getExamtype());
        examination.setChoiseList(choiseList);
        List<Blank> blankList = examMapper.selBlankByType(exam.getBlankIds(), exam.getExamtype());
        examination.setBlankList(blankList);
        return examination;
    }
}