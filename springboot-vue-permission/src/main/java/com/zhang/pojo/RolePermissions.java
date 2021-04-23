package com.zhang.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * (RolePermissions)实体类
 *
 * @author Distance
 * @since 2020-09-16 19:31:24
 */
@Data
@Getter
@Setter
public class RolePermissions implements Serializable {
    private static final long serialVersionUID = -53061696500971379L;

    
    private Integer id;
    
    private Integer roleId;
    
    private Integer permissionsId;
}