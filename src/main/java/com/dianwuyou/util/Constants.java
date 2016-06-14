package com.dianwuyou.util;

/**
 * Created by hebowei on 16/6/9.
 */
public class Constants {
    public static final boolean DEBUG = false;

    public static final String UPLOAD_FILE_STORE_LOCATION = "/Users/hebowei/IdeaProjects/dwy_website/src/webapp/static/img/upload/";
            //"D:/Code/Java/CreativeCrowd/src/main/webapp/static/img/upload/";
    public static final long MAX_FILE_SIZE = 5242880;  //5MB
    public static final long MAX_REQUEST_SIZE = 20971520;  //20MB
    public static final int FILE_SIZE_THRESHOLD = 0; // Size threshold after which files will be written to disk

    public static final String KEY_USER_UID = "_uid";
    public static final String KEY_USER_TYPE = "_utype";
    public static final String KEY_USER_TOKEN = "_utoken";
    public static final String KEY_FILE_UPLOAD = "_fupload";

    public static final String KEY_MOBILE_PHONE = "_mobile";

    public static final String KEY_CAPTCHA_SUCC_TOKEN = "_ctoken";
    public static final String KEY_CAPTCHA_SESSION ="_captcha";

}
