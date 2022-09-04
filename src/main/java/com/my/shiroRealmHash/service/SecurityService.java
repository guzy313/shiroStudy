package com.my.shiroRealmHash.service;

import com.my.shiroRealmHash.tools.DigestsUtil;

import java.util.HashMap;
import java.util.Map;

/**
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
