package com.my.shiroAuthorization.service;

import com.my.shiroRealmHash.tools.DigestsUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description 模拟查询数据，不分抽象实现了
 * @author Gzy
 * @version 1.0
 */
public class SecurityService {

    public Map<String,String> getPasswordByUserName(String userName){
        //模拟密码
        String password = "123";
        Map<String, String> map = DigestsUtil.entryptPassword(password);

        System.out.println("从数据库获取密码成功");
        return map;
    }

    /**
     * 获取角色列表(通过用户名称)
     * @param userName
     * @return
     */
    public List<String> findRoleByLoginName(String userName){
        List<String> list = new ArrayList<>();
        list.add("管理员");
        list.add("测试角色1");
        list.add("测试角色2");
        return list;
    }

    /**
     * 获取权限列表(通过用户名称)
     * @param userName
     * @return
     */
    public List<String> findPermissionByLoginName(String userName){
        List<String> list = new ArrayList<>();
        list.add("order:add");
        list.add("order:list");
        list.add("order:del");
        return list;
    }






}
