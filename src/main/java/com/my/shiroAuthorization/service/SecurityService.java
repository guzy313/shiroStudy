package com.my.shiroAuthorization.service;

import com.my.shiroRealmHash.tools.DigestsUtil;

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
        return map;
    }






}
