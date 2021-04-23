package com.zhang.mapper;

import com.zhang.pojo.Member;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (Member)表数据库访问层
 *
 * @author Distance
 * @since 2020-11-17 10:17:53
 */
public interface MemberMapper {

    @Select("select id,name,sex,classname,sno,phone,post from member")
    List<Member> selAllMember();

    @Select("<script>" +
            "select id,name,sex,classname,sno,phone,post " +
            "from member "+
            "where " +
            "<if test=\"member.sno != null and member.sno !=''\">sno like concat('%',#{member.sno},'%') </if>" +
            "<if test=\"member.sno != null and member.sno !=''\">or </if>" +
            "<if test=\"member.classname!=null and member.classname!=''\">classname like concat('%',#{member.classname},'%') </if>" +
            "<if test=\"member.classname!=null and member.classname!=''\">or </if>" +
            "<if test=\"member.sex!=null and member.sex!=''\">sex = #{member.sex} </if>" +
            "<if test=\"member.sex!=null and member.sex!=''\">or </if>" +
            "<if test=\"member.name!=null and member.name!=''\">name like concat('%',#{member.name},'%') </if>" +
            "<if test=\"member.name!=null and member.name!=''\">or </if>" +
            "<if test=\"member.phone!=null and member.phone!=''\">phone like concat('%',#{member.phone},'%') </if>" +
            "<if test=\"member.phone!=null and member.phone!=''\">or </if>" +
            "createtime BETWEEN 'NaN-NaN-NaN 00:00:00' and 'NaN-NaN-NaN 00:00:00' "+
            "limit #{pageNumber},5" +
            "</script>")
    List<Member> selMemberByCondition(@Param("member") Member member,@Param("pageNumber")Integer pageNumber);

    @Select("select count(id) from member")
    int getMemberLength();
}