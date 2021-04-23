package com.zhang.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


/**
 * (Blog)实体类
 *
 * @author Distance
 * @since 2020-09-20 20:32:31
 */
@Data
@Getter
@Setter
public class Blog implements Serializable {
    private static final long serialVersionUID = 917126248076967767L;

    
    private Integer id;
    
    private String title;
    
    private String content;
    
    private String charts;
    
    private String type;

    private List<String> labelList;

    private List<Comment> commentList;

    private String label;

    private String style;
    
    private Integer views;
    
    private String author;
    
    private String createtime;
}