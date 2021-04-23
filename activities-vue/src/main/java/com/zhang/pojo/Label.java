package com.zhang.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * (Label)实体类
 *
 * @author Distance
 * @since 2020-11-07 13:27:02
 */
@Data
@Getter
@Setter
public class Label implements Serializable {
    private static final long serialVersionUID = 383054836125981715L;

    
    private Integer id;
    
    private String name;
    
    private Integer count;

    public void setName(String name) {
        this.name = name;
    }
}