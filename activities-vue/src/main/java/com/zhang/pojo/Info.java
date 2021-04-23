package com.zhang.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * (Info)实体类
 *
 * @author Distance
 * @since 2020-10-15 20:32:05
 */
@Data
@Getter
@Setter
public class Info implements Serializable {
    private static final long serialVersionUID = 646210621871371551L;

    
    private Integer id;
    
    private String title;
    
    private String content;
    
    private String style;
    
    private String author;
    
    private String createtime;
    
    private Integer views;

    private String digest;
}