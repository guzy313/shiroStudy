package com.my.shiroRealmHash.client;

import com.my.shiroRealmHash.tools.DigestsUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;
import sun.security.smartcardio.SunPCSC;

import java.util.Map;

/**
 * @Description
 * @author Gzy
 * @version 1.0
 */
public class realmHashTest {

    @Test
    public void demo1(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiroRealmHash.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        //模拟输入的密码
        String password = "123";
        //传入登录用户输入信息——用以比对
        UsernamePasswordToken loginUser =
                new UsernamePasswordToken("testUser",password);

        //登录
        subject.login(loginUser);

        //验证登录结果
        System.out.println("登录结果:"+subject.isAuthenticated());


    }

}
