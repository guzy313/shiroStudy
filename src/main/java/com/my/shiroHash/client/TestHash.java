package com.my.shiroHash.client;

import com.my.shiroHash.tools.DigestsUtil;
import org.junit.Test;

public class TestHash {

    @Test
    public void testHashDemo(){

        String password = "蒋新荣";
        String s = DigestsUtil.sha1(password,"ttt");
        System.out.println(s);

    }

}
