package com.my.shiroRealmDemo1.service;

/**
 * @Description 模拟数据库
 * @author Gzy
 * @version 1.0
 */
public interface SecurityService {

    /**
     * 通过用户名返回密码
     * @param loginName
     * @return password
     */
    String findPasswordByLoginName(String loginName);

}
