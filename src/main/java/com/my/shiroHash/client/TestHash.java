package com.my.shiroHash.client;

import com.my.shiroHash.tools.DigestsUtil;
import org.junit.Test;

import java.util.Map;

public class TestHash {

    @Test
    public void testHashDemo(){

        String password = "123";
        Map<String, String> map = DigestsUtil.entryptPassword(password);
        String passwordAfterHash = map.get("password");
        String salt = map.get("salt");

        System.out.println("salt:"+salt);
        System.out.println("passwordAfterHash:"+passwordAfterHash);


    }

}
