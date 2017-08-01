package com.im4j.cmmon;

/**
 * Created by chenzp on 2017/7/27 0027.
 */
public class Result {
    private int code;
    private String msg;
    private Object data;
    public static int SUCCESS = 200;
    public static int ERROR = -1;

    public  int getCode() {
        return code;
    }

    public  void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Result getInstance(Object data){
        Result result = new Result();
        result.setCode(SUCCESS);
        result.setData(data);
        result.setMsg("");
        return  result;
    }
    public static Result getErrorInstance(String msg){
        Result result = new Result();
        result.setCode(ERROR);
        result.setMsg(msg);
        result.setData("");
        return  result;
    }
}
