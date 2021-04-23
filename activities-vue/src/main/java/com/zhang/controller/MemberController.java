package com.zhang.controller;

import com.zhang.mapper.MemberMapper;
import com.zhang.pojo.Member;
import com.zhang.service.MemberService;
import com.zhang.service.impl.MemberServiceImpl;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Member)表控制层
 *
 * @author Distance
 * @since 2020-11-17 10:17:53
 */
@RestController
@RequestMapping("member")
public class MemberController {
    /**
     * 服务对象
     */
    @Resource
    private MemberServiceImpl memberService;

    @Resource
    private MemberMapper memberMapper;

    @RequestMapping("getmemberList")
    public JSONObject getMemberList(Integer pageNumber){
        JSONObject object = new JSONObject();
        List<Member> memberList = memberService.findAllMember(pageNumber);
        object.put("code",200);
        object.put("msg","获取成功");
        object.put("memberList",memberList);
        object.put("total",memberMapper.getMemberLength());
        return object;
    }

    @RequestMapping("getmemberListByCondition")
    public JSONObject getmemberListByCondition(@Param("member")Member member,@Param("pageNumber")Integer pageNumber){
        JSONObject object = new JSONObject();
        List<Member> memberList = memberService.findMemberByCondition(member,pageNumber);
        object.put("code",200);
        object.put("msg","获取成功");
        object.put("memberList",memberList);
        object.put("total",memberList.size());
        return object;
    }

    @RequestMapping("exportMemberExcel")
    public JSONObject exportMemberExcel(){
        JSONObject object = new JSONObject();
        object.put("code",200);
        object.put("memberList",memberService.exportMemberExcel());
        return object;
    }
}