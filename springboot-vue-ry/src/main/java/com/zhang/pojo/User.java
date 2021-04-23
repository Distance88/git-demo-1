package com.zhang.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

import java.util.Date;
import java.io.Serializable;


/**
 * 用户信息表(User)实体类
 *
 * @author Distance
 * @since 2021-03-16 20:56:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 348390850173901652L;

    /**
    * 用户ID
    */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
    * 部门ID
    */
    private Integer deptId;
    /**
    * 登录账号
    */
    private String username;
    /**
    * 用户昵称
    */
    private String nickname;
    /**
    * 用户类型（00系统用户 01注册用户）
    */
    @TableField(select = false)
    private String type;
    /**
    * 用户邮箱
    */
    @TableField(select = false)
    private String email;
    /**
    * 手机号码
    */
    private String phone;
    /**
    * 用户性别（0男 1女 2未知）
    */
    private String sex;

    private String deptName;
    /**
    * 头像路径
    */
    private String avatar;
    /**
    * 密码
    */
    @TableField(select = false)
    private String password;
    /**
    * 盐加密
    */
    @TableField(select = false)
    private String salt;
    /**
    * 帐号状态（0正常 1停用）
    */
    private String status;
    /**
    * 删除标志（0代表存在 2代表删除）
    */
    @TableField(select = false)
    private String delFlag;
    /**
    * 最后登录IP
    */
    @TableField(select = false)
    private String loginIp;
    /**
    * 最后登录时间
    */
    @TableField(select = false)
    private String loginDate;
    /**
    * 密码最后更新时间
    */
    @TableField(select = false,fill = FieldFill.INSERT_UPDATE)
    private String pwdUpdateDate;
    /**
    * 创建者
    */
    @TableField(select = false)
    private String createBy;
    /**
    * 创建时间
    */
    @TableField(fill = FieldFill.INSERT)
    private String createTime;
    /**
    * 更新者
    */
    @TableField(select = false)
    private String updateBy;
    /**
    * 更新时间
    */
    @TableField(select = false,fill = FieldFill.INSERT_UPDATE)
    private String updateTime;
    /**
    * 备注
    */
    @TableField(select = false)
    private String remark;

    @TableField(exist = false)
    private String KeyWorld;

    @TableField(exist = false)
    private String startTime;

    @TableField(exist = false)
    private String endTime;
}