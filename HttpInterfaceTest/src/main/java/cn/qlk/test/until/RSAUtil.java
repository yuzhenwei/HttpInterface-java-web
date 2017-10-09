package cn.qlk.test.until;


import java.security.Key;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;  

@SuppressWarnings("restriction")
public class RSAUtil {
    
    
    private static String publicKeyStr = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC9wo1C9WsufgJe7vG00K6+/V//rkROfKkhY2zvgx6Y75V5lXr5tUZeBwX0Euimu4PYg9n7hsShPyJHHlss/B+LmVV5ChpvlPEmf3VQHgvvTRdPhjHWExcx05+ROKOuon0J4BmUfRmDrI+/59u69B2QM1YHcF1RLzwJymBr2CzHmwIDAQAB";
    private static String privateKeyStr = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAL3CjUL1ay5+Al7u8bTQrr79X/+uRE58qSFjbO+DHpjvlXmVevm1Rl4HBfQS6Ka7g9iD2fuGxKE/IkceWyz8H4uZVXkKGm+U8SZ/dVAeC+9NF0+GMdYTFzHTn5E4o66ifQngGZR9GYOsj7/n27r0HZAzVgdwXVEvPAnKYGvYLMebAgMBAAECgYEAqWYphxHhueJhqW/ztG/q37L/ZRekANEGhzjkAbjysqKGtMB9xLdP9xab+PR8XoPdQocKLKF1nWDn78coq7LzULda/fStHs/TQlAySa0Pdts/JSnTp1NRK64TgbiLqwjRrfY+Je9QhYtMiHoobDIjy9ktBknkGm+US03ZMSTUQZkCQQD0RE3niv//PqyBThLlttPyIaq7cHxONf/hfJV9gBixSh5LMcHoMB4Sc6B4qef6wwsHM2eMlqeoZV7aqjtt8wU1AkEAxt/9G8gx++VE3HHWJ0Z/LMdJK2Jw8V+6IScVkJwkbh8yENDkpro/2EwAq5ImK8iT5ZCKPBxfM9rMg8vPONBDjwJBANkEfnqC4mJx2m2fYea5gqCTDM8vZyFNlKNPPrmbv1R0V2nTMUYKygz2sdHCkpoWA4xIPW2IxDg2qAl6SQasbSkCQEgjH1BggaD5PM0pjaCZda/saaIPByDGtGEqKCxYNu6q6iInY4kGrfnrN6MEVEw1aVAv6bR8JhxNFToJR5U4FgkCQDT09A2pevWlDrpNBZHjcIDRvColfMogrtb2y1vVzMghAeq2arnO6HZ9vxERCVsp99iWFKOXxIVcEai6ZwZQvWE=";

    
    /**
     * 
     * <获取公钥字符串>
     * 
     * <详细描述>
     *
     * @return String <返回值描述>
     * @throws Exception 
     * @Throws 异常信息
     * @History 2015年6月23日 上午10:24:56 by chenlin
     */
    public static String getPublicKeyStr() throws Exception{
        PublicKey publicKey = RSAUtil.getPublicKey(publicKeyStr);
        return getKeyString(publicKey);
    }
    
    /**
     * 
     * <使用公钥进行加密数据>
     * 
     * <详细描述>
     *
     * @return String <返回值描述>
     * @throws Exception 
     * @Throws 异常信息
     * @History 2015年6月23日 上午10:27:05 by chenlin
     */
    public static String encryptByPublicKey(String message) throws Exception{
        PublicKey publicKey = RSAUtil.getPublicKey(publicKeyStr);
        // 公钥加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        // 明文
        byte[] plainText = message.getBytes();
        byte[] enBytes = cipher.doFinal(plainText);
        
        // Base64输出
        
        return Base64.encode(enBytes);
    }
    
    /**
     * 
     * <使用私钥进行解密数据>
     * 
     * <详细描述>
     *
     * @param message
     * @return String <返回值描述>
     * @throws Exception 
     * @Throws 异常信息
     * @History 2015年6月23日 上午10:27:18 by chenlin
     */
    public static String decryptByPrivateKey(String message) throws Exception{
        //密钥解密
        PrivateKey privateKey = RSAUtil.getPrivateKey(privateKeyStr);
        Cipher cipher = Cipher.getInstance("RSA");  
        cipher.init(Cipher.DECRYPT_MODE, privateKey);  
        
        //Base64解密
        byte[] deMessage = Base64.decode(message);
        byte[] output= cipher.doFinal(deMessage);
        
        return new String(output);
    }
    
    
    /**
     * 得到公钥
     */
    private static PublicKey getPublicKey(String key) throws Exception {
        byte[] keyBytes;
        keyBytes = Base64.decode(key);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }

    /**
     * 得到私钥
     */
    private static PrivateKey getPrivateKey(String key) throws Exception {
        byte[] keyBytes;
        keyBytes = Base64.decode(key);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }

    /**
     * 得到密钥字符串（经过base64编码）
     */
    public static String getKeyString(Key key) throws Exception {
        byte[] keyBytes = key.getEncoded();
        String s = Base64.encode(keyBytes);
        return s;
    }

    public static void main(String[] args) throws Exception {
           
        String ming = "123456";
        String mi = RSAUtil.encryptByPublicKey(ming);
        System.out.println("mi=="+mi);
     
    }

}
