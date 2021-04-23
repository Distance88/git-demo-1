package com.zhang.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhang.mapper.MemberMapper;
import com.zhang.pojo.Member;
import com.zhang.service.MemberService;
import com.zhang.utils.RedisUtil;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * (Member)表服务接口
 *
 * @author Distance
 * @since 2020-11-17 10:17:53
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Resource
    private MemberMapper memberMapper;
    
    @Resource
    private RedisUtil redisUtil;
    
    @Override
    public List<Member> findAllMember(Integer pageNumber) {
        String key = "memberList";
        Integer start = (pageNumber - 1) * 5;
        Integer end = start + 4;

        boolean hasKey = redisUtil.hasKey(key);
        if(hasKey){
            List<Object> memberList = redisUtil.lGet(key,start,end);
            return new ObjectMapper().convertValue(JSONArray.fromObject(memberList), new TypeReference<List<Member>>() {});
        }
        List<Member> memberList = memberMapper.selAllMember();
        List<Member> res = new LinkedList<>();
        for(int i=start;i<=(end >= memberList.size() ? memberList.size() - 1 : end)  ;i++){
            res.add(memberList.get(i));
        }
        redisUtil.lSet(key,JSONArray.fromObject(memberList),24);
        return res;
    }

    @Override
    public List<Member> findMemberByCondition(Member member, Integer pageNumber) {
        return memberMapper.selMemberByCondition(member,(pageNumber - 1 ) * 5);
    }

    @Override
    public List<Member> exportMemberExcel() {
        String key = "memberList";
        boolean hasKey = redisUtil.hasKey(key);
        if(hasKey){
            return new ObjectMapper().convertValue(JSONArray.fromObject(redisUtil.lGet(key,0,-1)), new TypeReference<List<Member>>() {});
        }
        return null;
    }
}