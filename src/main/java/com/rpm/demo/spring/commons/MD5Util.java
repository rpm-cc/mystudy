package com.rpm.demo.spring.commons;
import java.math.BigInteger;
/**
 * MD5加密工具
 * @author 秦文宝
 */
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;
public class MD5Util {  
	
	/**加密*/
    public final static String encode(String s) {  
        char hexDigits[] = { '0', '1', '2', '3', '4',  
                             '5', '6', '7', '8', '9',  
                             'A', 'B', 'C', 'D', 'E', 'F' };  
        try {  
            byte[] btInput = s.getBytes("UTF-8");  
            //获得MD5摘要算法的 MessageDigest 对象  
            MessageDigest mdInst = MessageDigest.getInstance("MD5");  
            //使用指定的字节更新摘要  
            mdInst.update(btInput);  
            //获得密文  
            byte[] md = mdInst.digest();  
            //把密文转换成十六进制的字符串形式  
            int j = md.length;  
            char str[] = new char[j * 2];  
            int k = 0;  
            for (int i = 0; i < j; i++) {  
                byte byte0 = md[i];  
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];  
                str[k++] = hexDigits[byte0 & 0xf];  
            }  
            return new String(str);  
        }  
        catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
    }
    
    public static String getMd5Digest(byte[] bytes) {

        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 cryptographic algorithm is not available.", e);
        }
        byte[] messageDigest = md.digest(bytes);
        BigInteger number = new BigInteger(1, messageDigest);
        // prepend a zero to get a "proper" MD5 hash value
        StringBuffer sb = new StringBuffer('0');
        sb.append(number.toString(16));
        return sb.toString();
    }
    public static void main(String[] args) {  
        System.out.print(MD5Util.encode("admin"));  
    }  
}  
