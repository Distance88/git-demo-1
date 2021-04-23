package com.zhang.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: Distance
 * Date: 2020/10/30/20:17
 */
@Data
@Getter
@Setter
public class ProAnswer {

    private Integer id;

    private String title;

    private List<Answer> answerList;

    public ProAnswer(Integer id, String title) {
        this.id = id;
        this.title = title;
    }
}
