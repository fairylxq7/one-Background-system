package com.gxan.service;

import com.gxan.common.R;

//处理核心业务，逻辑，封装等
public interface UserService {
      /*
      根据用户名和密码实现登录功能
       */
       R login(String username, String password);
}
