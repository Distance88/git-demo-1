package com.zhang.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * (Student)实体类
 *
 * @author Distance
 * @since 2021-01-21 17:22:56
 */
@Data
@Getter
@Setter
public class Student implements Serializable {
    private static final long serialVersionUID = -98057019262709400L;

    
    private Integer id;
    
    private String username;
    
    private String password;
    
    private String name;
    
    private String sex;
    
    private String studentclass;
    
    private String telephone;
    
    private String email;
}