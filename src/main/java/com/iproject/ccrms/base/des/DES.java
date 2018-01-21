package com.iproject.ccrms.base.des;


import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

/**
 * Created by ligaoyu on 18/1/17.
 */
public class DES {

    //密码，长度要是8的倍数
    private static final String password = "sss80288201091325707433253118984263qq85729wbd3549468wckl75018579537757772163084478873699447306034466200616411960574122434059469100235892702736860872901247123456";

    //测试
    public static void main(String args[]) {
        //待加密内容
        String str = "ssid-aldkfjwioafdsa";

        String result = DES.encrypt(str);
        System.out.println("加密后："+result);

        //直接将如上内容解密
        try {
            String decryResult = DES.decrypt(result);
            System.out.println("解密后："+decryResult);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }

    /**
     * 加密
     * @param data
     * @return byte[]
     */
    public static String encrypt(String data) {
        byte[] datasource = data.getBytes();
        try{
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(password.getBytes());

            //创建一个密匙工厂，然后用它把DESKeySpec转换成
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);

            //Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");

            //用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
            //现在，获取数据并加密
            //正式执行加密操作
            return encryptBase64(cipher.doFinal(datasource));
        }catch(Throwable e){
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 解密
     * @param data
     * @return byte[]
     * @throws Exception
     */
    public static String decrypt(String data) throws Exception {
        byte[] src = decryptBase64(data);
        // DES算法要求有一个可信任的随机数源
        SecureRandom random = new SecureRandom();
        // 创建一个DESKeySpec对象
        DESKeySpec desKey = new DESKeySpec(password.getBytes());
        // 创建一个密匙工厂
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        // 将DESKeySpec对象转换成SecretKey对象
        SecretKey securekey = keyFactory.generateSecret(desKey);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance("DES");
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, random);
        // 真正开始解密操作
        return new String(cipher.doFinal(src));
    }

    /**
     * BASE64 解密
     * @param key 需要解密的字符串
     * @return 字节数组
     * @throws Exception
     */
    public static byte[] decryptBase64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    /**
     * BASE64 加密
     * @param key 需要加密的字节数组
     * @return 字符串
     * @throws Exception
     */
    public static String encryptBase64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }
}
