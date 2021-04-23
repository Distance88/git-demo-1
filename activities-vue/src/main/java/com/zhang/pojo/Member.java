package com.zhang.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * (Member)实体类
 *
 * @author Distance
 * @since 2020-11-17 10:17:53
 */
@Data
@Getter
@Setter
public class Member implements Serializable {
    private static final long serialVersionUID = -61667914753262450L;

    
    private Integer id;
    
    private String name;
    
    private String sex;
    
    private String classname;
    
    private String sno;
    
    private String phone;
    
    private String post;
}