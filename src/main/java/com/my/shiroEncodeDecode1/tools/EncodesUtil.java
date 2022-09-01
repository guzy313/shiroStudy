package com.my.shiroEncodeDecode1.tools;

import org.apache.shiro.codec.Hex;

/**
 * 编码工具类
 * @author Gzy
 * @version 1.0
 */
public class EncodesUtil {

    /**
     * @Description Hex-String-byte[] Hex编码
     * @param input 输入字符数组
     * @return 字符串
     */
    public static String encodeHex(byte[] input){
        return Hex.encodeToString(input);
    }

    /**
     * @Description Hex-byte[]-String Hex解码
     * @param input 字符串
     * @return 字符数组
     */
    public static byte[] decodeHex(String input){
        return Hex.decode(input);
    }


}
