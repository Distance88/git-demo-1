package com.zhang.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * (User)实体类
 *
 * @author Distance
 * @since 2021-04-22 22:33:12
 */
@Data
@Getter
@Setter
public class User implements Serializable {
    private static final long serialVersionUID = 696871661030417477L;

    
    private Integer id;
    
    private String name;
    
    private String pwd;
    
    private String birthday;
    
    private Integer age;
}