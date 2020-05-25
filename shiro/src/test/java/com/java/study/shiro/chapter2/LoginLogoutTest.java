package com.java.study.shiro.chapter2;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

public class LoginLogoutTest {


    @Test
    public void helloWorld(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

        SecurityManager securityManager = factory.getInstance();
        // 全局设置，设置一次即可
        SecurityUtils.setSecurityManager(securityManager);

        //获取  subject 会绑定到当前线程，如果在web环境下，请求结束时需要接触绑定
        Subject subject = SecurityUtils.getSubject();
        //获取身份验证token,用户名/密码
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("zhang","123");
        try {
            //登陆，委托给 SecurityManager.login
            //SecurityManager 负责真正的身份验证逻辑，委托给 Authenticator进行身份验证
            //可以自定义插入自己的实现
            subject.login(usernamePasswordToken);
        }catch (AuthenticationException ex){

        }

        Assert.assertEquals(true,subject.isAuthenticated());

        //退出，委托给 SecurityManager.logout
        subject.logout();
    }



}
