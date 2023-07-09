package com.gxan.dao;

import com.gxan.pojo.User;

import java.sql.SQLException;

//和数据库交互
public interface UserDao {
    /*
    根据用户名和密码到数据库查询
    把查询结果封装到User对象中
    注意：查询是一条数据就封装到User对象中
     */
    User findUserByUsernameAndPwd(String username, String password) throws SQLException;
}
