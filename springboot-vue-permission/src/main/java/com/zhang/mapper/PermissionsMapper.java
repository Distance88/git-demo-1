package com.zhang.mapper;

import com.zhang.pojo.Permissions;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (Permissions)表数据库访问层
 *
 * @author Distance
 * @since 2020-09-16 19:31:23
 */
public interface PermissionsMapper {

    @Select("select p.id as id,p.permissionsname as permissionsname " +
            "from role_permissions rp " +
            "left join permissions p on p.id = rp.permissions_id " +
            "where rp.role_id = #{roleId}")
    List<Permissions> findPermissionsListByRoleId(Integer roleId);
}