package com.gxan.dao.impl;

import com.gxan.dao.UserDao;
import com.gxan.dbutils.JdbcBuild;
import com.gxan.pojo.User;

import java.sql.SQLException;

//和数据库交互
public class UserDaoImpl extends JdbcBuild implements UserDao {
    @Override
    public User findUserByUsernameAndPwd(String username, String password) throws SQLException {//从前端传递过来的值admin 123456
        String sql = "select * from user where username=? and password=?";
        Object[] params = {username,password};
        return super.queryEntity(User.class,sql,params);
    }
}
