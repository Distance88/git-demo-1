package com.zhang.service.impl;

import com.zhang.mapper.SidebarMapper;
import com.zhang.pojo.Sidebar;
import com.zhang.service.SidebarService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (Sidebar)表服务接口
 *
 * @author Distance
 * @since 2021-03-18 09:20:53
 */
@Service
public class SidebarServiceImpl implements SidebarService {

    @Resource
    private SidebarMapper sidebarMapper;


    @Override
    public List<Sidebar> findAllSideBar() {

        List<Sidebar> selectList = sidebarMapper.selAllSideBar();



        List<Sidebar> sidebarList = new ArrayList<>();

        for(int i=0;i<selectList.size();i++){

            if(selectList.get(i).getParentId() == 0){
                sidebarList.add(selectList.get(i));
            }
        }

        for(Sidebar sidebar:selectList){

            List<Sidebar> childList = getChildList(sidebar.getId(), selectList);

            sidebar.setChildren(childList);
        }

        return sidebarList;
    }


    public List<Sidebar> getChildList(Integer id,List<Sidebar> menuList){
        List<Sidebar> childList = new ArrayList<>();


        for(Sidebar Sidebar:menuList){
            if(id == Sidebar.getParentId()){
                childList.add(Sidebar);
            }
        }

        //递归
        for (Sidebar Sidebar:childList) {
            Sidebar.setChildren(getChildList(Sidebar.getId(),menuList));
        }
        if (childList.size() == 0){
            return null;
        }
        return childList;

    }
}