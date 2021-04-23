package com.zhang.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * (Label)实体类
 *
 * @author Distance
 * @since 2020-09-25 13:48:55
 */
@Data
@Getter
@Setter
public class Label implements Serializable {
    private static final long serialVersionUID = -36403648734389537L;

    
    private Integer id;
    
    private String name;
}