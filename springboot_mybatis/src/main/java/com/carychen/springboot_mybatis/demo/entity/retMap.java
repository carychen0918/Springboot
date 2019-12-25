package com.carychen.springboot_mybatis.demo.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class retMap {
    public   String msg;
    public int code =0;
    public  Object data;
    public int count;
    public boolean success;
    public Map<String,Object> map = new HashMap<>();

    public  retMap(String msg,int code, List data, int count,boolean success){
        this.msg=msg;
        this.code=code;
        this.data=data;
        this.count=count;
        this.success=success;
    }

    public retMap(){

    }

    public  Map<String, Object> getMap() {
        this.map.put("msg",this.msg);
        this.map.put("code",this.code);
        this.map.put("data",this.data);
        this.map.put("count",this.count);
        this.map.put("success",this.success);
        return map;
    }

    public  String getMsg() {
        return msg;
    }

    public  void setMsg(String msg) {
        this.msg = msg;
    }

    public  int getCode() {
        return code;
    }

    public  void setCode(int code) {
        this.code = code;
    }

    public  Object getData() {
        return data;
    }

    public  void setData(Object data) {
        this.data = data;
    }

    public  int getCount() {
        return count;
    }

    public  void setCount(int count) {
        this.count = count;
    }

    public  boolean isSuccess() {
        return success;
    }

    public  void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return msg+"_"+code+"_"+count+"_"+ data.toString();
    }
}
