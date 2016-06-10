package com.dianwuyou.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.UUID;

/**
 * Created by hebowei on 16/6/10.
 */
public class Encoding {
    public static String SALT_PREFIX = "dwy_";

    /**
     * Generate random salt according to SALT_PREFIX and current time
     * @return
     */
    public static String getSalt(){
        String timestampStr = SALT_PREFIX + String.valueOf(System.currentTimeMillis());
        Random random = new Random();
        timestampStr += random.nextInt();
        return timestampStr;
    }

    public static String getEncodedString(String str){
        String reStr = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(str.getBytes());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bytes){
                int bt = b&0xff;
                if (bt < 16){
                    stringBuffer.append(0);
                }
                stringBuffer.append(Integer.toHexString(bt));
            }
            reStr = stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return reStr;
    }

    public static String getRandomUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
