package com.my.shiroAuthorization.client;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class shiroAuthorizationTest {


    @Test
    public void testPermission(){
        //登录并返回登录主体信息
        Subject subject = loginDemo();
        //判断是否具有管理员权限
        boolean isAdmin = subject.hasRole("管理员");
        if(isAdmin){
            System.out.println("是管理员,具有最高权限");
        }else{
            System.out.println("不是管理员");
        }
        try {
            subject.checkRole("xxx");
        }catch (Exception e){
            System.out.println("当前用户没有xxx角色");
        }

        try {
            subject.checkPermission("order:list");
            System.out.println("当前用户拥有查看权限");
        }catch (Exception e){
            System.out.println("当前用户没有查看的权限");
        }

    }

    public Subject loginDemo(){
        //创建安全管理器工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiroAuthorization.ini");
        //通过工厂获取安全管理器
        SecurityManager securityManager = factory.getInstance();
        //使用安全工具使 安全管理器 生效
        SecurityUtils.setSecurityManager(securityManager);
        //使用安全工具获取主体
        Subject subject = SecurityUtils.getSubject();

        //创建授权令牌，并传入用户输入的登录信息
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken();
        usernamePasswordToken.setUsername("测试用户");
        usernamePasswordToken.setPassword("123".toCharArray());

        System.out.println("开始登录");
        //使用令牌登录主体
        subject.login(usernamePasswordToken);
        //输出是否登录成功
        System.out.println("是否登录成功:"+subject.isAuthenticated());

        return subject;
    }


}
