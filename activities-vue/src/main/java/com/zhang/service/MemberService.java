package com.zhang.service;

import com.zhang.pojo.Member;

import java.util.List;

/**
 * (Member)表服务接口
 *
 * @author Distance
 * @since 2020-11-17 10:17:53
 */
public interface MemberService {

    List<Member> findAllMember(Integer pageNumber);

    List<Member> findMemberByCondition(Member member,Integer pageNumber);

    List<Member> exportMemberExcel();
}