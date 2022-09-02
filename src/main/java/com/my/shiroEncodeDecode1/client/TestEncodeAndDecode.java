package com.my.shiroEncodeDecode1.client;

import com.my.shiroEncodeDecode1.tools.EncodesUtil;
import org.junit.Test;

public class TestEncodeAndDecode {


    @Test
    public void testHex(){
        String hexStr = "world";
        //编码
        String flag = EncodesUtil.encodeHex(hexStr.getBytes());
        System.out.println(flag);
        //解码
        String afterHandler = new String(EncodesUtil.decodeHex(flag));

        System.out.println(" 是否相同:"+hexStr.equals(afterHandler));

    }

}
