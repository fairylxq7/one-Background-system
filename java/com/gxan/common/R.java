package com.gxan.common;
/*
不带分页的响应实体类:泛型类
封装code msg data
 */
public class R<T> {
    private Integer code;//响应状态码：返回给前端判断执行成功或者失败的标记 200 成功  500 服务器问题(java问题)  0 LayUI规定数据表格要想成功展示数据必须是0
    private String msg;//提示信息：成功或者失败
    private T data;//服务器给前端响应回来的数据：User对象 list Map

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
