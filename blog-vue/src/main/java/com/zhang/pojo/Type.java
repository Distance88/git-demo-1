package com.zhang.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * (Type)实体类
 *
 * @author Distance
 * @since 2020-09-24 09:16:54
 */
@Data
@Getter
@Setter
public class Type implements Serializable {
    private static final long serialVersionUID = 305514893328251891L;

    
    private Integer id;
    
    private String name;

    private Integer count;
}