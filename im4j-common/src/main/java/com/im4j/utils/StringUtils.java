package com.im4j.utils;

import java.util.UUID;

/**
 * Created by chenzp on 2017/7/27 0027.
 */
public class StringUtils {

    public static String getUuid(){
        return UUID.randomUUID().toString().replace("-","");
    }

    public static boolean isEmpty(String param){
        return param == null || param.length()==0;
    }

}
