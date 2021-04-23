package com.zhang.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * (User)实体类
 *
 * @author Distance
 * @since 2020-10-08 20:52:46
 */
@Data
@Getter
@Setter
public class User implements Serializable {
    private static final long serialVersionUID = -91482558314410047L;

    
    private Integer id;
    
    private String username;
    
    private String password;
}