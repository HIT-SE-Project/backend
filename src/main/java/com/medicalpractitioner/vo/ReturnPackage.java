package com.medicalpractitioner.vo;

import org.apache.ibatis.jdbc.Null;

public class ReturnPackage {
    private int code;
    private String msg;
    private Object data;

    public ReturnPackage() {
    }

    public static ReturnPackage pack(int code,String msg,Object data){
        ReturnPackage res = new ReturnPackage();
        res.setCode(code);
        res.setMsg(msg);
        res.setData(data);
        return res;
    }
    public static  ReturnPackage suc(){
        ReturnPackage res = new ReturnPackage();
        res.setCode(200);
        res.setMsg("successfully");
        res.setData(null);
        return res;
    }

    public static  ReturnPackage suc(Object data){
        ReturnPackage res = new ReturnPackage();
        res.setCode(200);
        res.setMsg("successfully");
        res.setData(data);
        return res;
    }

    public static ReturnPackage fail(){
        ReturnPackage res = new ReturnPackage();
        res.setCode(400);
        res.setMsg("failed");
        res.setData(null);
        return res;
    }

    public static ReturnPackage fail(Object data){
        ReturnPackage res = new ReturnPackage();
        res.setCode(400);
        res.setMsg("failed");
        res.setData(data);
        return res;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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
}
