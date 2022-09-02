package com.my.shiroEncodeDecode1.tools;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;

/**
 * 编码工具类
 * @author Gzy
 * @version 1.0
 */
public class EncodesUtil {

    /**
     * @Description Hex-byte[]-String Hex 字节数组 转 字符串
     * @param input 输入字符数组
     * @return 字符串
     */
    public static String encodeHex(byte[] input){
        return Hex.encodeToString(input);
    }

    /**
     * @Description Hex-String-byte[] Hex字符串 转 字节数组
     * @param input 字符串
     * @return 字符数组
     */
    public static byte[] decodeHex(String input){
        return Hex.decode(input);
    }

    /**
     * @Description Base64-byte[]-String Base64 字节数组 转 字符串
     * @param input
     * @return
     */
    public static String encodeBase64(byte[] input){
        return Base64.encodeToString(input);
    }

    /**
     * @Description Base64-String-byte[] Bas64字符串 转 字节数组
     * @param input
     * @return
     */
    public static byte[] decodeBase64(String input){
        return Base64.decode(input);
    }


}
