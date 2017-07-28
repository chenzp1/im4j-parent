package com.im4j.cmmon;

/**
 * Created by chenzp on 2017/7/27 0027.
 */
public class Result {

    private static Result result;

    private static int code;

    private String msg;

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static int SUCCESS = 200;

    public static int ERROR = -1;

    public  int getCode() {
        return code;
    }

    public static void setCode(int code) {
        Result.code = code;
    }

    static {
        result = new Result();
    }

    public static Result getInstance(Object data){
        result.setCode(SUCCESS);
        result.setData(data);
        result.setMsg("");
        return  result;
    }

    public static Result getErrorInstance(String msg){
        result.setCode(ERROR);
        result.setMsg(msg);
        result.setData(new Object());
        return  result;
    }
}
