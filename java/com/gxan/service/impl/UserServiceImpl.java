package com.gxan.service.impl;

import com.gxan.common.R;
import com.gxan.dao.UserDao;
import com.gxan.dao.impl.UserDaoImpl;
import com.gxan.pojo.User;
import com.gxan.service.UserService;
import com.gxan.utils.MD5Utils;

import java.sql.SQLException;

//处理核心业务，逻辑，封装、加密等
public class UserServiceImpl implements UserService {

    //使用多态创建Dao对象
    private UserDao userDao = new UserDaoImpl();

    @Override
    public R login(String username, String password) {
        R r = new R();
        try {
            //使用MD5Utils对密码加密：因为数据库中密码是加密的
            String newpwd = MD5Utils.encrypt(password, MD5Utils.MD5_KEY);
            //调用UserDao
            User user = userDao.findUserByUsernameAndPwd(username, newpwd);
            //逻辑处理
            if(user!=null){//登录成功
                r.setCode(200);
                r.setMsg("登录成功");
                r.setData(user);
            }else {//登录失败
                r.setCode(500);
                r.setMsg("用户名或者密码错误");
            }
        } catch (Exception e) {//进到异常中
            e.printStackTrace();
            r.setCode(501);
            r.setMsg("系统开小差，请联系管理员");
        }
        return r;
    }
}
