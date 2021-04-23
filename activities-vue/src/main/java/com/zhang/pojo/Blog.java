package com.zhang.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * (Blog)实体类
 *
 * @author Distance
 * @since 2020-11-06 10:21:20
 */
@Data
@Getter
@Setter
public class Blog implements Serializable {
    private static final long serialVersionUID = 625341659944337798L;

    
    private Integer id;
    
    private String title;
    
    private String content;
    
    private String charts;
    
    private String type;
    
    private String label;
    
    private String style;

    private String digest;
    
    private Integer views;
    
    private String author;
    
    private String createtime;

    private String photo;
}