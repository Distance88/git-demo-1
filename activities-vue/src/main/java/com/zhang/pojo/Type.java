package com.zhang.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * (Type)实体类
 *
 * @author Distance
 * @since 2020-11-07 09:52:27
 */
@Data
@Getter
@Setter
public class Type implements Serializable {
    private static final long serialVersionUID = -57919331275719978L;

    
    private Integer id;
    
    private String name;
    
    private Integer count;

}