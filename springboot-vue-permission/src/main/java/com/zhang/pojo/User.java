package com.zhang.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.io.Serializable;
import java.util.List;


/**
 * (User)实体类
 *
 * @author Distance
 * @since 2020-09-16 19:32:01
 */
@Data
@Getter
@Setter
public class User implements Serializable {
    private static final long serialVersionUID = 331520323818702014L;

    
    private Integer id;
    
    private String username;
    
    private String password;
    
    private String email;
    
    private String phone;
    
    private String address;
    
    private String createtime;

    private Integer status;

    private List<Role> roleList;
}