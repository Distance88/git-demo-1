package com.zhang.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * (Role)实体类
 *
 * @author Distance
 * @since 2021-04-22 22:32:57
 */
@Data
@Getter
@Setter
public class Role implements Serializable {
    private static final long serialVersionUID = 289991812738504786L;

    
    private Integer id;
    
    private String name;
    
    private String descri;
}