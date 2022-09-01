package com.my.shiroRealmDemo2;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * @author Gzy
 * @version 1.0
 */
public class ShiroDemo2 {

    @Test
    public void loginDemo2(){
        //创建安全管理器工厂
        Factory<SecurityManager>  factory =
                new IniSecurityManagerFactory("classpath:shiro1.ini");
        //通过安全管理器工厂获取 安全管理器 实例
        SecurityManager securityManager = factory.getInstance();
        //使用安全工具使 安全管理器生效
        SecurityUtils.setSecurityManager(securityManager);
        //使用安全工具获取主体
        Subject subject = SecurityUtils.getSubject();

        //创建 用户名密码令牌类 传入登录用户信息
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken();
        usernamePasswordToken.setUsername("测试用户1");
        usernamePasswordToken.setPassword("123".toCharArray());

        //往主体传入 令牌类（存储用户 输入的用户名密码 的类
        //此处会从指定的realm中获取用户信息列表进行比对
        subject.login(usernamePasswordToken);

        //输出 subject 记录的登录结果(是否认证成功)
        System.out.println("是否认证成功："+subject.isAuthenticated());



    }


}
