package com.zhang.mapper;

import com.zhang.pojo.Role;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * (Role)表数据库访问层
 *
 * @author Distance
 * @since 2020-09-16 19:31:24
 */
public interface RoleMapper {

    @Select("select r.id as id,r.rolename as rolename,r.descript as descript " +
            "from user_role ur " +
            "left join role r on r.id = ur.role_id " +
            "where ur.user_id = #{userId}")
    @Results(
            value = {
                    @Result(id = true,property = "id",column = "id"),
                    @Result(property = "rolename",column = "rolename"),
                    @Result(property = "descript",column = "descript"),
                    @Result(property = "permissionsList",column = "id",
                            many = @Many(select = "com.zhang.mapper.PermissionsMapper.findPermissionsListByRoleId",fetchType = FetchType.DEFAULT))
            }
    )
    List<Role> findRoleListByUserId(Integer userId);
}