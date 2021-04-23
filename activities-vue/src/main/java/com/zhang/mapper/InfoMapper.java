package com.zhang.mapper;

import com.zhang.pojo.Info;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * (Info)表数据库访问层
 *
 * @author Distance
 * @since 2020-10-15 20:32:06
 */
public interface InfoMapper {


    @Select("select * from info")
    List<Info> selAllInfo();

    @Select("select * from info where id = #{id}")
    Info selInfoById(Integer id);

    @Insert("insert into info values(default,#{title},#{content},#{digest},#{style},#{author},0,#{createtime})")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    void addInfo(Info info);

    @Select("select count(id) from info")
    int selInfoLength();

    @Select("select count(id) from info where id < #{id}")
    int selInfoBeforeCount(Integer id);

    @Select("<script>" +
            "select * from info where " +
            "<if test=\"info.title != null and info.title !=''\">title like concat('%',#{info.title},'%') </if>" +
            "<if test=\"info.title != null and info.title !=''\">or </if>" +
            "<if test=\"info.style!=null and info.style!=''\">style =#{info.style} </if>" +
            "<if test=\"info.style!=null and info.style!=''\">or </if>" +
            "<if test=\"info.author!=null and info.author!=''\">author=#{info.author} </if>" +
            "<if test=\"info.author!=null and info.author!=''\">or </if>" +
            "<if test=\"starTime!=null and starTime!=''\" >createtime BETWEEN(#{starTime}) and(#{endTime}) </if>" +
            "limit #{pageNumber},5" +
            "</script>")
    List<Info> selInfoByCondition(@Param("info") Info info, @Param("starTime") String starTime, @Param("endTime") String endTime,@Param("pageNumber")Integer pageNumber);

    @Delete("delete from info where id = #{id}")
    void delInfoById(Integer id);

    @Delete("<script>" +
            "delete from info where id in " +
            "<foreach collection='ids' item='id' open='(' separator=',' close=')'>" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    void batchDelInfoByIds(Integer ids[]);

    @Select("select title,createtime from info " +
            "order by id desc limit 0,3")
    List<Info> selRecentInfo();

}