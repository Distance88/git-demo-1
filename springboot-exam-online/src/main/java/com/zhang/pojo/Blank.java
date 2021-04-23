package com.zhang.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * (Blank)实体类
 *
 * @author Distance
 * @since 2021-01-24 19:06:31
 */
@Data
@Getter
@Setter
public class Blank implements Serializable {
    private static final long serialVersionUID = -52403800001824783L;

    
    private Integer id;
    
    private String question;
    
    private String answer;
    
    private Integer questiontype;
    
    private Integer type;
}