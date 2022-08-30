package com.my.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * @Description shiro demo 1
 * @author Gzy
 * @version 1.0
 */
public class HelloShiro {

    @Test
    public void shiroLogin(){
        //导入ini配置创建工厂
        Factory<SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:shiro.ini");

        //工厂构建安全管理器
        SecurityManager securityManager = factory.getInstance();

        //使用工具生效安全管理器
        SecurityUtils.setSecurityManager(securityManager);

        //使用工具获得subject主体
        Subject subject = SecurityUtils.getSubject();

        //构建账户密码
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken();
        usernamePasswordToken.setUsername("jay");
        usernamePasswordToken.setPassword("123".toCharArray());
        //使用subject主体登录

        subject.login(usernamePasswordToken);

        //打印登录信息
        System.out.println(subject.isAuthenticated());

    }


}
