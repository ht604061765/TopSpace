/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-22 下午2:32:22
 * TODO //
 */
package com.topspace.core.utils;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringEscapeUtils;

public final class StringUtil {


    /**
     * 判断一个字符串是否为空，即 为 null 或 "" 或 " "

     */
    public static boolean isEmpty(String str) {
        if((str == null) || (str.trim().length() == 0) || ("null".equals(str))){
            return true;
        }else{
            return false;
        }
    }

    public static String toString(Object object) {
        return object == null ? "" : object.toString();
    }

    /**
     * 字符串转换成数组
     * <p>
     * 例子:tokenizeToStringArray("one;two",";")<br>
     * return {"one","two"}
     * </p>
     * 
     * @param str 字符串
     * @param delimiters 分隔符
     * @return
     */
    public static String[] split(String str, String delimiters) {
        return split(str, delimiters, true, true);
    }

    /**
     * 字符串转换成数组
     * <p>
     * 例子:tokenizeToStringArray("one;two",";",false,true)<br>
     * return {"one","two"}
     * </p>
     * 
     * @param str
     *            字符串
     * @param delimiters
     *            分隔符
     * @param trimTokens
     *            是否去掉前后空格
     * @param ignoreEmptyTokens
     *            是否过滤掉空的部分
     * @return
     */
    public static String[] split(String str, String delimiters, boolean trimTokens, boolean ignoreEmptyTokens) {
        if(str == null){
            return null;
        }
        StringTokenizer st = new StringTokenizer(str, delimiters);
        List<String> tokens = new ArrayList<String>();
        while(st.hasMoreTokens()){
            String token = st.nextToken();
            if(trimTokens){
                token = token.trim();
            }
            if(!ignoreEmptyTokens || token.length() > 0){
                tokens.add(token);
            }
        }
        return (String[]) tokens.toArray(new String[tokens.size()]);
    }

    /**
     * 比较两个字符串是否相等。 只要有一个字符串为null，返回false。
     * 
     * @param str1
     * @param str2
     * @return boolean
     */
    public static boolean equals(String str1, String str2) {
        if(str1 == null || str2 == null){
            return false;
        }
        return str1.equals(str2);
    }

    /**
     * 比较两个字符串是否相等（忽略大小写）。 只要有一个字符串为null，返回false。
     * 
     * @param str1
     * @param str2
     * @return boolean
     */
    public static boolean equalsIgnoreCase(String str1, String str2) {
        if(str1 == null || str2 == null){
            return false;
        }

        return str1.equalsIgnoreCase(str2);
    }

    // 可根据需要修改，去掉了分辨不清的i,l,o,O等字母。
    private static char _mapTable[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
            'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /**
     * 产生一个由数字+字母组成的随机字符串。
     * 
     * @param length
     * @return
     */
    public static String randomStr(int length) {
        StringBuilder sb = new StringBuilder(length + 16);
        for(int i = 0; i < length; ++i){
            int index = (int) (_mapTable.length * Math.random());
            sb.append(_mapTable[index]);
        }
        return sb.toString();
    }

    private static char[] _numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /**
     * 产生由纯数字组成的随机字符串。
     * 
     * @param length
     *            长度。
     * @return
     */
    public static String randomNumStr(int length) {
        StringBuilder sb = new StringBuilder(length + 16);
        for(int i = 0; i < length; ++i){
            int index = (int) (_numbers.length * Math.random());
            sb.append(_numbers[index]);
        }
        return sb.toString();
    }

    /**
     * 用占位符拼接字符串。比如 “今天是{0}年{1}月{2}日”。
     * 
     * @param pattern
     *            模式，比如 “今天是{0}年{1}月{2}日”。
     * @param parmas
     *            参数，任意多个参数，要同pattern中的占位符个数相同。
     * @return
     */
    public static String format(String pattern, Object... parmas) {
        return MessageFormat.format(pattern, parmas);
    }

    public static String ecapseHtml(String input) {
        return StringEscapeUtils.escapeHtml4(input);
    }

    public static String ecapseXml(String input) {
        return StringEscapeUtils.escapeXml11(input);
    }

    /**
     * 邮箱地址合法性校验
     * 
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {
        Pattern pattern = Pattern.compile("^\\w+@\\w+\\.(com|cn)");
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches()){
            return true;
        }
        return false;
    }

    /**
     * 手机号码合法性校验
     * 
     * @param phone
     * @return
     */
    public static boolean checkPhone(String phone) {
        Pattern pattern = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher matcher = pattern.matcher(phone);
        if(matcher.matches()){
            return true;
        }
        return false;
    }

    /**
     * 把字节数组转换成16进制字符串
     * 
     * @param bArray
     * @return
     */
    public static final String bytesToHexString(byte[] bytes) {
        return Hex.encodeHexString(bytes);
    }

    /**
     * 把16进制字符串转换成字节数组
     * 
     * @param hex
     * @return
     */
    public static byte[] hexStringToBytes(String hex) {
        try{
            return Hex.decodeHex(hex.toCharArray());
        }catch(DecoderException ex){
            ex.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        // StringUtil cc=new StringUtil();
        // System.out.println(cc.checkPhone("1898888888"));
        // System.out.println(cc.isDate("1996-02-29"));
        String str = "c81e728d9d4c2f636f067f89cc14862c";
        byte[] bytes = hexStringToBytes(str);
        System.out.println(bytes);
        System.out.println(bytesToHexString(bytes));

    }

}


