package com.zhang.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * (Permissions)实体类
 *
 * @author Distance
 * @since 2020-09-16 19:31:21
 */
@Data
@Getter
@Setter
public class Permissions implements Serializable {
    private static final long serialVersionUID = 566003323383453859L;

    
    private Integer id;
    
    private String permissionsname;
}