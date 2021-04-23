package com.zhang.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * (Answer)实体类
 *
 * @author Distance
 * @since 2020-10-23 18:11:16
 */
@Data
@Getter
@Setter
public class Answer implements Serializable {
    private static final long serialVersionUID = 917602731070475034L;

    
    private Integer id;
    
    private Integer pid;
    
    private String answer;
    
    private String author;
    
    private String time;


}