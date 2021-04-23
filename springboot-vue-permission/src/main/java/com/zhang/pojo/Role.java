package com.zhang.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


/**
 * (Role)实体类
 *
 * @author Distance
 * @since 2020-09-16 19:31:24
 */
@Data
@Getter
@Setter
public class Role implements Serializable {
    private static final long serialVersionUID = 241095065435276539L;

    
    private Integer id;
    
    private String rolename;
    
    private String descript;

    private List<Permissions> permissionsList;
}