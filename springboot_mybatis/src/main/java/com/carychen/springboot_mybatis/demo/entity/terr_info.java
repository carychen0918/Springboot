package com.carychen.springboot_mybatis.demo.entity;
import java.io.Serializable;
import java.util.List;

/**
 * Created by chentao
 * Date by 2019-11-14
 * 无敌太寂寞
 */
public class terr_info implements Serializable {
     String title; //标题
     int id; //id
     String field;//	一般对应表字段名
     List<terr_info> children;//子节点
     String url;//菜单路径
     Boolean spread = false;

    public terr_info(String title,int id,String url){
        this.url = url;
        this.id =id;
        this.title = title;
    }

    public void setSpread(Boolean spread){
        this.spread = spread;
    }

    public Boolean getSpread(){
        return spread;
    }

    public String getUrl(){return  url;}

    public void setUrl(String url){this.url = url;}

    public  String getTitle() {
        return title;
    }

    public  void setTitle(String title) {
        this.title = title;
    }

    public  int getId() {
        return id;
    }

    public  void setId(int id) {
        this.id = id;
    }

    public  String getField() {
        return field;
    }

    public  void setField(String field) {
        this.field = field;
    }

    public  List<terr_info> getChildren() {
        return children;
    }

    public  void setChildren(List<terr_info> children) {
        this.children = children;
    }

    public String toString(){
        return "id:"+id+"title:"+title+"url："+url+"field："+field+"<terr_infos>:";
    }
}
