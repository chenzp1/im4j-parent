package com.im4j.controller;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chenzp on 2017/10/10 0010.
 */
public class Test {
    public static void main(String[] args) {

        try {
            Lock lock = new ReentrantLock();
            Pattern pattern = Pattern.compile("[a][a][0-9]+");
            Matcher matcher = pattern.matcher("(aa0=?  aa55=?  aa43");
            System.out.println(matcher.find());
        }catch (Throwable e){
            System.out.println("异常消息:"+e.getMessage());
        }
    }
}
