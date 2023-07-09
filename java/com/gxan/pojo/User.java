package com.gxan.pojo;
/*
使用封装创建实体类
实体类和表一一对应：名,字段名，字段类型
Ctrl+R 替换
Alt 选中多行
生成get和set方法右键选择generate
 */
//用户类
public class User {
    private Integer id;//用户编号，阿里规约规定使用基本数据类型的包装类型
    private String username;//用户姓名
    private String password;//用户密码

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
